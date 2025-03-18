package English_revision_software;

public class Shuju {
    private String[] repertory_word;
    private String[] now_meaning;
    private String[] Chinese_reference_library;
    private int Combo_count;
    private int Combo_count_max=1;
    public Shuju() {
    }

    public String[] getRepertory_word() {
        //英语单词总库
        repertory_word = new String[]{"i", "you", "he", "she", "we", "you", "her", "him", "us", "me", "to talk", "with",
                "with me", "to talk with me", "now", "want", "You want to talk with me now", "have to do",
                "You have to do it", "every day", "You have to do it every day", "to help", "me",
                "to help me", "You have to help me", "You have to help me now", "to believe", "me",
                "to believe me", "You have to believe me", "the food", "to eat", "to eat the food",
                "You need to eat the food"};
        return repertory_word;
    }

    public String[] getChinese_reference_library() {
        Chinese_reference_library = new String[]{"我", "你", "他", "她", "我们", "放句尾的：你", "放句尾的：她",
                "放句尾的：他", "放句尾的：我们", "放句尾的：我", "说话", "和/与", "和我", "和我说话",
                "现在", "想要", "你想要现在和我说话", "必须做", "你必须做这件事", "每天",
                "你必须每天做这件事", "帮助", "放句尾的：我", "帮助我", "你必须帮助我",
                "你必须现在帮助我", "相信", "放句尾的：我", "相信我", "你必须相信我",
                "这个食物", "吃", "吃这个食物", "你需要吃这个食物"};
        return Chinese_reference_library;
    }

    public int getCombo_count() {
        return Combo_count;
    }

    public void setCombo_count(int combo_count) {
        Combo_count = combo_count;
    }

    public int getCombo_count_max() {
        return Combo_count_max;
    }

    public void setCombo_count_max(int combo_count_max) {
        Combo_count_max = combo_count_max;
    }
}
