package com.section.beginner.linkedlists.doubly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrowserHistoryTest {

    private BrowserHistory browserHistory;
    private static final String HOMEPAGE = "google.com";

    @BeforeEach
    void setUp() {
        browserHistory = new BrowserHistory(HOMEPAGE);
    }

    @Test
    @DisplayName("Constructor should initialize history with the homepage")
    void testInitialization_ShouldStartWithHomepage() {
        assertEquals(HOMEPAGE, browserHistory.back(0), "Initial page should be the homepage.");
        assertEquals(HOMEPAGE, browserHistory.forward(0), "Initial page should be the homepage.");
    }

    @Test
    @DisplayName("Visiting new pages should add them to history")
    void testVisit_ShouldAppendToHistory() {
        String youtube = "youtube.com";
        String facebook = "facebook.com";

        browserHistory.visit(youtube);
        assertEquals(HOMEPAGE, browserHistory.back(1), "Should go back to homepage.");

        browserHistory.forward(1);

        browserHistory.visit(facebook);
        assertEquals(youtube, browserHistory.back(1), "Should go back to the previously visited page.");
    }

    @Test
    @DisplayName("Going back and forward should navigate correctly through history")
    void testBackAndForward_ShouldNavigateHistory() {
        browserHistory.visit("youtube.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("linkedin.com");

        String currentPage1 = browserHistory.back(2); // Move back 2 steps
        assertEquals("youtube.com", currentPage1, "Should be on youtube.com after going back 2 steps.");

        String currentPage2 = browserHistory.forward(1); // Move forward 1 step
        assertEquals("facebook.com", currentPage2, "Should be on facebook.com after going forward 1 step.");
    }

    @Test
    @DisplayName("Visiting a new page after going back should clear the forward history")
    void testVisitAfterGoingBack_ShouldClearForwardHistory() {
        browserHistory.visit("youtube.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("linkedin.com");

        browserHistory.back(2);
        browserHistory.visit("github.com");

        String currentPage = browserHistory.forward(1);
        assertEquals("github.com", currentPage, "Forward history should be cleared; should remain on github.com.");

        String previousPage = browserHistory.back(1);
        assertEquals("youtube.com", previousPage, "The previous page should now be youtube.com.");
    }

    @Test
    @DisplayName("Back with steps exceeding history should return the first page")
    void testBack_WithStepsExceedingHistory_ShouldReturnFirstPage() {
        browserHistory.visit("youtube.com");
        browserHistory.visit("facebook.com");

        String currentPage = browserHistory.back(10);

        assertEquals(HOMEPAGE, currentPage, "Should be at the homepage (first page in history).");
    }

    @Test
    @DisplayName("Forward with steps exceeding history should return the last page")
    void testForward_WithStepsExceedingHistory_ShouldReturnLastPage() {
        String lastPage = "linkedin.com";
        browserHistory.visit("youtube.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit(lastPage);

        browserHistory.back(3);

        String currentPage = browserHistory.forward(10);

        assertEquals(lastPage, currentPage, "Should be at the last page in history.");
    }

    @Test
    @DisplayName("A complex sequence of operations should work as expected")
    void testComplexScenario() {
        browserHistory.visit("youtube.com");
        browserHistory.visit("facebook.com");
        assertEquals(HOMEPAGE, browserHistory.back(2));

        assertEquals("youtube.com", browserHistory.forward(1));

        browserHistory.visit("linkedin.com");
        assertEquals("linkedin.com", browserHistory.forward(1));

        assertEquals(HOMEPAGE, browserHistory.back(10));
        assertEquals("youtube.com", browserHistory.forward(1));
    }
}