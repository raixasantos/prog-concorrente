package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

func init() {
	rand.Seed(time.Now().UnixNano())
}

func Random() int {
	randomNumber := rand.Intn(2)
	return randomNumber
}

func makePoint() int {
	return Random()
}

// Player represents a player in a game.
type Player struct {
	id, points int
}

// NewPlayer returns an empty player of the specified id and points.
func NewPlayer(id, points int) *Player {
	return &Player{id: id, points: points}
}

var bestPlayer Player

func updateWinner(player Player) {
	if player.points > bestPlayer.points {
		bestPlayer.id = player.id
		bestPlayer.points = player.points
	}
}

func move(player Player, court chan bool, waitGroup *sync.WaitGroup) {
	for bestPlayer.points < 7 {
		status := <-court
		if !status {
			return
		}
		fmt.Println(status)
		fmt.Println("Starting move")
		if makePoint() == 1 {
			player.points++
			fmt.Println("Player", player.id, "Points: ", player.points)
		}
		updateWinner(player)
		court <- true
	}

}

func main() {
	var waitGroup sync.WaitGroup
	court := make(chan bool)

	player01 := NewPlayer(1, 0)
	player02 := NewPlayer(2, 0)

	waitGroup.Add(2)
	fmt.Println("Starting")
	go move(*player01, court, &waitGroup)
	go move(*player02, court, &waitGroup)
	court <- true

	fmt.Println("Finishing channel", <-court)
	for i := 0; i < 2; i++ {
		waitGroup.Done()
	}

	waitGroup.Wait()
	fmt.Println("Best player:", bestPlayer.id, " Points:", bestPlayer.points)
}
