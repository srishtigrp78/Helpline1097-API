package com.iemr.helpline1097.data.co.beneficiarycall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class CallTypeTest {
    @InjectMocks
    private CallType callType;

    @Test
    void testNewCallType() {
        // Arrange and Act
        CallType actualCallType = new CallType();

        // Assert
        assertFalse(actualCallType.getFitToBlock());
        assertTrue(actualCallType.getFitForFollowUp());
    }

    @Test
    void testNewCallType2() {
        // Arrange and Act
        CallType actualCallType = new CallType(1, "Call Type", "Call Type Desc", "Call Group Type", true, true);

        // Assert
        assertEquals("Call Group Type", actualCallType.getCallGroupType());
        assertEquals("Call Type Desc", actualCallType.getCallTypeDesc());
        assertEquals("Call Type", actualCallType.getCallType());
        assertEquals(1, actualCallType.getCallTypeID().intValue());
        assertTrue(actualCallType.getFitForFollowUp());
        assertTrue(actualCallType.getFitToBlock());
    }

    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"callTypeID\":null,\"callGroupType\":null,\"callType\":null,\"callTypeDesc\":null,\"providerServiceMapID\""
                        + ":null,\"deleted\":null,\"createdBy\":null,\"fitToBlock\":false,\"fitForFollowUp\":true}",
                (new CallType()).toString());
    }
}
