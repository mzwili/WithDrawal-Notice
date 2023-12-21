package com.enviro.assessment.grad001.ThuthukaniMthiyane.POJO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoticeResponseTest {
    @Test
    public void testGetFinalNotice() {
        // Arrange
        String notice = "Test Notice";
        NoticeResponse noticeResponse = new NoticeResponse(notice);

        // Act
        String result = noticeResponse.getFinalNotice();

        // Assert
        assertEquals(notice, result);
    }

    @Test
    public void testSetFinalNotice() {
        // Arrange
        String notice = "Test Notice";
        NoticeResponse noticeResponse = new NoticeResponse("");

        // Act
        noticeResponse.setFinalNotice(notice);

        // Assert
        assertEquals(notice, noticeResponse.getFinalNotice());
    }

    @Test
    public void testConstructor() {
        // Arrange
        String notice = "Test Notice";

        // Act
        NoticeResponse noticeResponse = new NoticeResponse(notice);

        // Assert
        assertEquals(notice, noticeResponse.getFinalNotice());
    }

    @Test
    public void testSetFinalNoticeWithNull() {
        // Arrange
        NoticeResponse noticeResponse = new NoticeResponse("Initial Notice");

        // Act
        noticeResponse.setFinalNotice(null);

        // Assert
        assertNull(noticeResponse.getFinalNotice());
    }

}