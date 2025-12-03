package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FinancialServiceRevenueTest {

    private FinancialService service;
    private RevenueRepository mockRepo;

    @BeforeEach
    void setup() throws Exception {
        service = new FinancialService();
        mockRepo = mock(RevenueRepository.class);

        var field = FinancialService.class.getDeclaredField("revenueRepository");
        field.setAccessible(true);
        field.set(service, mockRepo);
    }

    @Test
    void testAddRevenue() throws SQLException {
        Revenue rev = new Revenue(1, "Sales", "100");
        service.addRevenue(rev);
        verify(mockRepo, times(1)).insert(rev);
    }

    @Test
    void testUpdateRevenue() throws SQLException {
        Revenue rev = new Revenue(2, "Interest", "150");
        service.updateRevenue(rev);
        verify(mockRepo, times(1)).update(rev);
    }

    @Test
    void testDeleteRevenue() throws SQLException {
        service.deleteRevenue(1);
        verify(mockRepo, times(1)).delete(1);
    }

    @Test
    void testCalculateTotalRevenueEmpty() throws SQLException {
        when(mockRepo.findAll()).thenReturn(List.of());
        assertEquals(0.0, service.calculateTotalRevenue());
    }
}
