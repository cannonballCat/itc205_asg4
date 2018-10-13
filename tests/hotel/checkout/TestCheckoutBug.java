package hotel.checkout;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import hotel.HotelHelper;
import hotel.credit.CreditCard;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;

@ExtendWith(MockitoExtension.class)
class TestCheckoutBug {
	
	@Mock
	CheckoutUI checkoutUi;
	
	Hotel hotel;
	Guest guest;
	Room room;
	CreditCard creditCard;
	CheckoutCTL control;
	
	int roomId = 101;
	
	@BeforeEach
	void setUp() throws Exception {
		hotel = HotelHelper.loadHotel();
		control = new CheckoutCTL(hotel);
	}
	
	@Test
	void testCheckoutBug() {
		//arrange
		//act
		//assert
	}

}
