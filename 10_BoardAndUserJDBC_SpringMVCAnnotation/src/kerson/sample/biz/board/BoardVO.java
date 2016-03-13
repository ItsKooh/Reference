package kerson.sample.biz.board;

public class BoardVO {

    private int seq;
    private String title;
    private String content;
    private String writer;
    private int cnt;
    
    private String chgDvcd;
    
    public String getChgDvcd() {
		return chgDvcd;
	}
	public void setChgDvcd(String chgDvcd) {
		this.chgDvcd = chgDvcd;
	}
	public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String contents) {
        this.content = contents;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", title=" + title + ", contents="
                + content + ", cnt=" + cnt + "]";
    }
    
    
}
