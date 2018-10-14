package hotel.checkout;

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
class TestCheckoutBug {
	
	@Mock
	CheckoutUI checkoutUi;
	
	Hotel hotel;
	CheckoutCTL control;
	
	int roomId = 301;
	
	@BeforeEach
	void setUp() throws Exception {
		hotel = HotelHelper.loadHotel();
		control = new CheckoutCTL(hotel);
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

}
