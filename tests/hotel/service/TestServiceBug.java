package hotel.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import hotel.HotelHelper;
import hotel.entities.Hotel;

@ExtendWith(MockitoExtension.class)
class TestServiceBug {
	
	@Mock
	RecordServiceUI checkoutUi;
	
	Hotel hotel;
	RecordServiceCTL control;
	
	int roomId = 301;
	
	@BeforeEach
	void setUp() throws Exception {
		hotel = HotelHelper.loadHotel();
		control = new RecordServiceCTL(hotel);
	}
	
	@Test
	void testRecordServiceBug() {
		//arrange
		hotel.checkout(roomId);
		control.setRoomState();
		//act
		control.roomNumberEntered(roomId);
		//assert
		//If this bug did not occur then an error would occur here
	}
}