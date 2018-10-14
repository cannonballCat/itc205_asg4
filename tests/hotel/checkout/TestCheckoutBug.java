package hotel.checkout;

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

@ExtendWith(MockitoExtension.class)
class TestCheckoutBug {
	
	@Mock
	CheckoutUI ui;
	
	Hotel hotel;
	CheckoutCTL control;
	
	int roomId = 301;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		hotel = HotelHelper.loadHotel();
		control = new CheckoutCTL(hotel);
		control.checkoutUI = ui;
	}
	
	@Test
	void testCheckoutBug() {
		//arrange
		control.setRoomState();
		//act
		control.roomIdEntered(roomId);
		//assert
		assertEquals(control.getTotal(), 0);
	}
	
	@Test
	void testCheckoutFixed() {
		//arrange
		control.setRoomState();
		//act
		control.roomIdEntered(roomId);
		//assert
		assertEquals(control.getTotal(), 7);
	}

}
