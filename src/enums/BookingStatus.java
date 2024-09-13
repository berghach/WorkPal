package enums;

public enum BookingStatus {
    ONGOING("ongoing"),
    CONFIRMED("confirmed"),
    CANCELED("canceled"),
    PAST("past");

    private final String bookingStatus;

    BookingStatus(String bookingStatus){
        this.bookingStatus = bookingStatus;
    }
    public String getBookingStatus(){
        return bookingStatus;
    }
}
