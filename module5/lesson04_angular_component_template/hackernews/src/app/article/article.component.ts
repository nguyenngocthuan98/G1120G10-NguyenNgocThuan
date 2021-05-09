import {Component, OnInit} from '@angular/core';
import {Article} from '../article';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  article: Article = {};
  articles: Article[] = [
    {
      title: 'Google',
      url: 'https://www.google.com.vn/'
    },
    {
      title: 'Google',
      url: 'https://www.google.com.vn/'
    },
    {
      title: 'Google',
      url: 'https://www.google.com.vn/'
    }
  ];

  public time = new Date();
  intervalId;

  constructor() {
  }

  ngOnInit(): void {
    this.intervalId = setInterval(() => {
      this.time = new Date();
    }, 1000);
  }

  addNewArticle() {
    this.articles.push(this.article);
  }
}
