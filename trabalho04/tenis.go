package main

import (
	"fmt"
	"math/rand"
	"time"
)

// Player represents a player in a game.
type Player struct {
	id, points int
}

// NewPlayer returns an empty player of the specified id and points.
func NewPlayer(id, points int) *Player {
	return &Player{id: id, points: points}
}

func main() {
	player01 := NewPlayer(1, 0)
	player02 := NewPlayer(2, 0)
	fmt.Println("Hello, World! Número sorteado:", rand.Intn(1))
	fmt.Println("Id do jogador 01:", player01.id)
	fmt.Println("Id do jogador 02:", player02.id)
	time.Sleep(time.Second / 30)
}
