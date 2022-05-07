package ee.ut.library.domain.enums;

public enum Category {
    ACTION_AND_ADVENTURE("Action and adventure"),
    ALTERNATE_HISTORY("Alternate history"),
    ANTHOLOGY("Anthology"),
    ART_ARCHITECTURE("Art/architecture"),
    AUTOBIOGRAPHY("Autobiography"),
    BIOGRAPHY("Biography"),
    BUSINESS_ECONOMICS("Business/economics"),
    CHICK_LIT("Chick lit"),
    CHILDREN_S("Children's"),
    CLASSIC("Classic"),
    COMIC_BOOK("Comic book"),
    COMING_OF_AGE("Coming-of-age"),
    COOKBOOK("Cookbook"),
    CRAFTS_HOBBIES("Crafts/hobbies"),
    CRIME("Crime"),
    DIARY("Diary"),
    DICTIONARY("Dictionary"),
    DRAMA("Drama"),
    ENCYCLOPEDIA("Encyclopedia"),
    FAIRYTALE("Fairytale"),
    FANTASY("Fantasy"),
    GRAPHIC_NOVEL("Graphic novel"),
    GUIDE("Guide"),
    HEALTH_FITNESS("Health/fitness"),
    HISTORICAL_FICTION("Historical fiction"),
    HISTORY("History"),
    HOME_AND_GARDEN("Home and garden"),
    HORROR("Horror"),
    HUMOR("Humor"),
    JOURNAL("Journal"),
    MATH("Math"),
    MEMOIR("Memoir"),
    MYSTERY("Mystery"),
    PARANORMAL_ROMANCE("Paranormal romance"),
    PHILOSOPHY("Philosophy"),
    PICTURE_BOOK("Picture book"),
    POETRY("Poetry"),
    POLITICAL_THRILLER("Political thriller"),
    PRAYER("Prayer"),
    RELIGION_SPIRITUALITY_AND_NEW_AGE("Religion, spirituality, and new age"),
    REVIEW("Review"),
    ROMANCE("Romance"),
    SATIRE("Satire"),
    SCIENCE("Science"),
    SCIENCE_FICTION("Science fiction"),
    SELF_HELP("Self help"),
    SHORT_STORY("Short story"),
    SPORTS_AND_LEISURE("Sports and leisure"),
    SUSPENSE("Suspense"),
    TEXTBOOK("Textbook"),
    THRILLER("Thriller"),
    TRAVEL("Travel"),
    TRUE_CRIME("True crime"),
    WESTERN("Western"),
    YOUNG_ADULT("Young adult");
    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String description() {
        return description;
    }
}
