public class Dictionary {

    public static final String TRACISZ_RUCH_MSG = "TRACISZ RUCH";

    public static final String TRACISZ_RUCH_MSG_ENG = "YOU LOSE";

    public static final String TRACISZ_PUNKTY_MSG = "TRACISZ WSZYSTKIE PUNKTY";

    public static final String PODAJ_LITERE_MSG = "PODAJ LITERĘ SPÓŁGŁOSKĘ LUB KUP SAMOGŁOSKĘ ZA 200";

    public static final String NIE_MASZ_PUNKTOW_MSG = "NIE MASZ WYSTARCZAJĄCEJ LICZBY PUNKTÓW";

    public static  String translateToEng(String tekst)
    {
        if(tekst.equals(TRACISZ_RUCH_MSG))
            return TRACISZ_RUCH_MSG_ENG;

        return tekst;
    }

}
