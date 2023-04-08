package com.mycompany.controllers;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import com.mycompany.tourpackage.controllers.TourService;
import com.mycompany.tourpackage.entity.TourDetail;
import com.mycompany.tourpackage.entity.TourPackage;
import com.mycompany.tourpackage.dao.TourPackageRepository;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

@SpringBootTest(classes = TourService.class)
class TourRestControllerTest {

	@Autowired
	TourService tourService;

	@MockBean
	TourPackageRepository repo;

	@Captor
	ArgumentCaptor<TourDetail> captor;

	@Test
	void testCreateCoupon() {
		TourPackage tour = insertTour();
		TourPackage tourSaved = insertTour();
		tourSaved.setCatId(1);
		tourSaved.setId(1L);
		when(repo.save(any())).thenReturn(tourSaved);

	}

//	@Test
//	void testGetCouponByCode() {
//		Coupon couponSaved=makeCoupon();
//		couponSaved.setId(1L);
//		when(repo.findByCode("AUTUMN_SALE")).thenReturn(couponSaved);
//		Coupon couponReturn = couponRestController.getCoupon("AUTUMN_SALE");
//		assertEquals(couponReturn.getId(),1L);
//		assertEquals(couponReturn.getCode(),"AUTUMN_SALE");
//		assertEquals(couponReturn.getDiscount(),BigDecimal.valueOf(10.0));
//		assertEquals(couponReturn.getExpDate(),"31/12/2024");
//		verify(repo, new Times(1)).findByCode("AUTUMN_SALE");
//	}
//	
//	@Test
//	void testFindAllCoupons() {
//		Coupon couponSaved=makeCoupon();
//		couponSaved.setId(1L);
//		ArrayList<Coupon> coupons = new ArrayList<>();
//		coupons.add(couponSaved);
//		when(repo.findAll()).thenReturn(coupons);
//		List<Coupon> couponsFound = couponRestController.getAllCoupons();
//		Coupon couponFound= couponsFound.get(0);
//		assertEquals(couponFound.getId(),1L);
//		assertEquals(couponFound.getCode(),"AUTUMN_SALE");
//		assertEquals(couponFound.getDiscount(),BigDecimal.valueOf(10.0));
//		assertEquals(couponFound.getExpDate(),"31/12/2024");
//		verify(repo, new Times(1)).findAll();
//	}
	private TourPackage insertTour() {
		TourPackage tour = new TourPackage();
		tour.setCatId(1);
		tour.setTourname("IndiaTour");
		return tour;

	}

}
