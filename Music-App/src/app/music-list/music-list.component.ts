import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-music-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
  ],
  templateUrl: './music-list.component.html',
  styleUrls: ['./music-list.component.css'],
})
export class MusicListComponent {
  songs = [
    {
      name: 'Shape of You',
      artist: 'Ed Sheeran',
      album: 'Divide',
      duration: '4:24',
      rating: 5,
      image: 'assets/Album1.jpg',
    },
    {
      name: 'Blinding Lights',
      artist: 'The Weeknd',
      album: 'After Hours',
      duration: '3:20',
      rating: 4,
      image: 'assets/Album2.jpg',
    },
    {
      name: 'Levitating',
      artist: 'Dua Lipa',
      album: 'Future Nostalgia',
      duration: '3:23',
      rating: 3,
      image: 'assets/Album3.jpg',
    },
    {
      name: 'Believer',
      artist: 'Imagine Dragons',
      album: 'Evolve',
      duration: '3:37',
      rating: 5,
      image: 'assets/Album4.jpg',
    },
  ];

  filterType: 'artist' | 'album' | '' = '';
  filterValue: string = '';

  get uniqueArtists() {
    return [...new Set(this.songs.map((s) => s.artist))];
  }
  get uniqueAlbums() {
    return [...new Set(this.songs.map((s) => s.album))];
  }

  get filteredSongs() {
    if (!this.filterType || !this.filterValue) return this.songs;

    return this.songs.filter((song) => {
      if (this.filterType === 'artist') return song.artist === this.filterValue;
      if (this.filterType === 'album') return song.album === this.filterValue;
      return true;
    });
  }
}
