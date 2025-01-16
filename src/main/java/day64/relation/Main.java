package day64.relation;

public class Main {
    public static void main(String[] args) {
        Member member1 = Member.builder().index(1).id("qwer").name("강호동").build();

        Board board1 = Board.builder().index(1).title("제목1").content("내용1").build();
        board1.setWriter(member1);

        System.out.println("1번 게시물 작성자 아이디: " + board1.getWriter().getId());

        member1.getWrittenBoards().add(board1);
        System.out.println("1번 멤버가 작성한 게시물: " + member1.getWrittenBoards().get(0).getTitle());
        
        Comment comment1 = Comment.builder().index(1).content("댓글1").build();
        member1.getWrittenComments().add(comment1);
        System.out.println("1번 댓글의 작성자 아이디: "+ comment1.getWriter().getId());
    }
}