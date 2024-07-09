package com.iemr.helpline1097.data.co.beneficiarycall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class ServiceProvidedTest {
    @InjectMocks
    private ServiceProvided serviceProvided;

    @Test
    void testGettersAndSetters() {
        // Arrange
        ServiceProvided serviceProvided = new ServiceProvided();

        // Act
        serviceProvided.setCounsellingService("Counselling Service");
        serviceProvided.setFeedbackSystem("Feedback System");
        serviceProvided.setInformationService("Information Service");
        serviceProvided.setReferralService("Referral Service");
        serviceProvided.setServiceID(1L);
        String actualToStringResult = serviceProvided.toString();
        String actualCounsellingService = serviceProvided.getCounsellingService();
        String actualFeedbackSystem = serviceProvided.getFeedbackSystem();
        String actualInformationService = serviceProvided.getInformationService();
        String actualReferralService = serviceProvided.getReferralService();

        // Assert that nothing has changed
        assertEquals("Counselling Service", actualCounsellingService);
        assertEquals("Feedback System", actualFeedbackSystem);
        assertEquals("Information Service", actualInformationService);
        assertEquals("Referral Service", actualReferralService);
        assertEquals(
                "{\"ServiceID\":\"1\",\"InformationService\":\"Information Service\",\"CounsellingService\":\"Counselling"
                        + " Service\",\"ReferralService\":\"Referral Service\",\"FeedbackSystem\":\"Feedback System\"}",
                actualToStringResult);
        assertEquals(1L, serviceProvided.getServiceID().longValue());
    }

    @Test
    void testNewServiceProvided() {
        // Arrange and Act
        ServiceProvided actualServiceProvided = new ServiceProvided();

        // Assert
        assertNull(actualServiceProvided.getServiceID());
        assertNull(actualServiceProvided.getCounsellingService());
        assertNull(actualServiceProvided.getFeedbackSystem());
        assertNull(actualServiceProvided.getInformationService());
        assertNull(actualServiceProvided.getReferralService());
    }

    @Test
    void testNewServiceProvided2() {
        // Arrange and Act
        ServiceProvided actualServiceProvided = new ServiceProvided(1L, "Information Service", "Counselling Service",
                "Referral Service", "Feedback System");

        // Assert
        assertEquals("Counselling Service", actualServiceProvided.getCounsellingService());
        assertEquals("Feedback System", actualServiceProvided.getFeedbackSystem());
        assertEquals("Information Service", actualServiceProvided.getInformationService());
        assertEquals("Referral Service", actualServiceProvided.getReferralService());
        assertEquals(1L, actualServiceProvided.getServiceID().longValue());
    }
}
