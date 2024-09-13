package entities;

import java.time.LocalDateTime;

public class Subsrcription {
    private int id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean isExpired;
    private boolean isCanceled;
    private Member member;
    private Plan plan;

    public Subsrcription(LocalDateTime startDateTime, LocalDateTime endDateTime, Member member, Plan plan){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.member = member;
        this.plan = plan;
    }
    public int getId(){
        return id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    
}
