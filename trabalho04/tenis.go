package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

var waitGroup sync.WaitGroup

// runs before anything else in the package generating the seed
func init() {
	rand.Seed(time.Now().UnixNano())
}

// Generate a random number between 0 and 1 that represents a point
func makePoint() int {
	randomNumber := rand.Intn(2)
	return randomNumber
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
var pointSet int = 7

// Checks if the player have a better score and update the winner.
func updateWinner(player Player) {
	if player.points > bestPlayer.points {
		bestPlayer.id = player.id
		bestPlayer.points = player.points
	}
	fmt.Println("Updating best player:", bestPlayer.id, " Points:", bestPlayer.points)
}

// Checks if the game is over.
func gameover() bool {
	fmt.Println("BestPlayer:", bestPlayer.points, " PointSet:", pointSet)
	return bestPlayer.points == pointSet
}

// Represents moves in a game from one player.
func move(player Player, court chan bool) {

	waitGroup.Done()

	for true {
		status := <-court

		if !status {
			fmt.Println("Status in exception: ", status)
			return
		}

		fmt.Println("Status: ", status)
		fmt.Println("Player", player.id, "starting move")

		if makePoint() == 1 {
			player.points++
			fmt.Println("Player", player.id, "Points: ", player.points)
			updateWinner(player)
			if gameover() {
				fmt.Println("Closing the court channel...")
				close(court)
				return
			}
		} else {
			fmt.Println("Player", player.id, "no point")
		}
		court <- true
	}

}

// Main method.
func main() {

	court := make(chan bool)

	player01 := NewPlayer(1, 0)
	player02 := NewPlayer(2, 0)

	waitGroup.Add(2)

	fmt.Println("Starting game")
	go move(*player01, court)
	go move(*player02, court)

	court <- true

	waitGroup.Wait()

	fmt.Println("Best player:", bestPlayer.id, " Points:", bestPlayer.points)
}
