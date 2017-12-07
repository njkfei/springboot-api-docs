package com.niejinkun.springbootgradle.model;

public class Greeting {
   @ApiModelProperty(value = "id", required = true)
  private final long id;
  @ApiModelProperty(value = "content", required = true)
  private final String content;
  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }
  public long getId() {
    return id;
  }
  public String getContent() {
    return content;
  }
}
