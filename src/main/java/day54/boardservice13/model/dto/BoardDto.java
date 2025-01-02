package day54.boardservice13.model.dto;

public class BoardDto {
    private int index;
    private String title;
    private String content;
    private String date;
    private String writer;
    private String password;

    public BoardDto() {}

    public BoardDto(int index, String title, String content, String date, String writer, String password) {
        this.index = index;
        this.title = title;
        this.content = content;
        this.date = date;
        this.writer = writer;
        this.password = password;
    }

    public int getIndex() { return index; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getDate() { return date; }
    public String getWriter() { return writer; }
    public String getPassword() { return password; }

    public void setIndex(int index) { this.index = index; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setDate(String date) { this.date = date; }
    public void setWriter(String writer) { this.writer = writer; }
    public void setPassword(String password) { this.password = password; }
}