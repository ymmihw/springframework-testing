package com.ymmihw.springframework;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articles")
@Getter
@Setter
public class Article {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private String title;

  private String content;
}
