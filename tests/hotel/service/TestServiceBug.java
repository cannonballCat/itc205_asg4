package hotel.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import hotel.HotelHelper;
import hotel.entities.Hotel;
import hotel.service.RecordServiceUI.State;

@ExtendWith(MockitoExtension.class)
class TestServiceBug {
	
	@Mock
	RecordServiceUI ui;
	
	Hotel hotel;
	RecordServiceCTL control;
	
	int roomId = 301;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		hotel = HotelHelper.loadHotel();
		control = new RecordServiceCTL(hotel);
		control.recordServiceUI = ui;
	}
	
	@Test
	void testRecordServiceBug() {
		//arrange
		hotel.checkout(roomId);
		control.setRoomState();
		//act
		control.roomNumberEntered(roomId);
		//assert
		assertEquals(control.getState(), State.SERVICE);
	}
	
	@Test
	void testRecordServiceFixed() {
		//arrange
		String mesg = String.format("No active booking for room id: %d", roomId);
		hotel.checkout(roomId);
		control.setRoomState();
		//act
		control.roomNumberEntered(roomId);
		//assert
		verify(ui).displayMessage(mesg);
	}
}