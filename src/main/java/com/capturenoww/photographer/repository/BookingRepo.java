package com.capturenoww.photographer.repository;

import com.capturenoww.photographer.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String> {

    List<Booking> findByCustomer_Id(String customerId);

    List<Booking> findByPhotographer_Id(String photographerId);

    @Transactional
    @Modifying
    @Query("UPDATE Booking b SET b.status = :newStatus WHERE b.bookingId = :bookingId")
    void updateBookingStatusById(String bookingId, String newStatus);
}
