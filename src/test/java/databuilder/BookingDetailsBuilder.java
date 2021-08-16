package databuilder;

import datamodel.BookingDetailsModel;

public class BookingDetailsBuilder extends BookingDetailsModel {

    BookingDetailsModel bookingModel = new BookingDetailsModel();

    public BookingDetailsBuilder(String[] bookingDetails){
        bookingModel.setDeparture(bookingDetails[0]);
        bookingModel.setDestination(bookingDetails[1]);
        bookingModel.setName(bookingDetails[2]);
        bookingModel.setAddress(bookingDetails[3]);
        bookingModel.setCity(bookingDetails[4]);
        bookingModel.setState(bookingDetails[5]);
        bookingModel.setZipCode(bookingDetails[6]);
        bookingModel.setCardType(bookingDetails[7]);
        bookingModel.setCardNumber(bookingDetails[8]);
        bookingModel.setMonth(bookingDetails[9]);
        bookingModel.setYear(bookingDetails[10]);
        bookingModel.setCardName(bookingDetails[11]);
    }

    public BookingDetailsModel getBookingDetails(){
        return bookingModel;
    }
}
