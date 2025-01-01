package day52.boardService8mvc.model;

public class BoardDto {
    private String title;
    private String content;
    private String password;

    public BoardDto(String title, String content, String password) {
        this.title=title;
        this.content=content;
        this.password=password;
    }


    public String getTitle() { return title; }
    public String getPassword() { return password; }
    public String getContent() { return content; }

    public void setTitle(String title) { this.title = title; }
    public void setPassword(String password) { this.password = password; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "BoardDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", password=" + password +
                '}';
    }
}
