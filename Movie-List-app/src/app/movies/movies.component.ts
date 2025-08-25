import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatGridListModule } from '@angular/material/grid-list';
import { FormsModule } from '@angular/forms';

interface Movie {
  title: string;
  poster: string;
  genre: string;
  rating: number;
  description: string;
}

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatSelectModule,
    MatIconModule,
    MatGridListModule,
    FormsModule,
  ],
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css'],
})
export class MoviesComponent {
  selectedGenre: string = 'All';

  movies: Movie[] = [
    {
      title: 'Inception',
      poster: 'assets/Inception.jpg',
      genre: 'Sci-Fi',
      rating: 5,
      description: 'A mind-bending thriller by Christopher Nolan.',
    },
    {
      title: '3_Idiots',
      poster: 'assets/3_idiots.jpg',
      genre: 'Action',
      rating: 4,
      description: 'Marvel superheroes unite to save the universe.',
    },
    {
      title: 'The Dark Knight',
      poster: 'assets/The Dark Night.jpg',
      genre: 'Action',
      rating: 5,
      description: 'Batman faces the Joker in this iconic movie.',
    },
    {
      title: 'Interstellar',
      poster: 'assets/Interstellar.jpg',
      genre: 'Sci-Fi',
      rating: 4,
      description: 'A space journey through wormholes and time.',
    },
  ];

  get filteredMovies() {
    return this.selectedGenre === 'All'
      ? this.movies
      : this.movies.filter((m) => m.genre === this.selectedGenre);
  }

  get averageRating(): number {
    const total = this.movies.reduce((sum, m) => sum + m.rating, 0);
    return total / this.movies.length;
  }
}
