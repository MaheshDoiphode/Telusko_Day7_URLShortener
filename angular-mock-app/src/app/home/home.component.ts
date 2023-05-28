import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  shortenedUrl: string = '';

  constructor(private http: HttpClient) { }

  getShortenedUrl(originalUrl: string) {
    const urlMapping = { originalUrl };
    this.http.post('http://localhost:8080/url', urlMapping, { responseType: 'text' }).subscribe(response => {
      this.shortenedUrl = response;
    }, error => {
      console.error(error);
    });
  }
}
