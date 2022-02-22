package Enums;
public enum Axe {
    BRONZE {
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 1;
        }
        @Override
        public int ItemId() {
            return 1351;
        }

        @Override
        public String Name() { return "Bronze axe"; }
    },

    IRON {
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 15;
        }
        @Override
        public int ItemId() {
            return 1349;
        }
        public String Name() { return "Iron axe"; }
    },

    STEEL{
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 30;
        }
        @Override
        public int ItemId() {
            return 1353;
        }
        public String Name() { return "Steel axe"; }
    },

    BLACK{
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 35;
        }
        @Override
        public int ItemId() {
            return 1361;
        }
        public String Name() { return "Black axe"; }
    },

    MITHRIL{
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 45;
        }
        @Override
        public int ItemId() {
            return 1355;
        }
        public String Name() { return "Mithril axe"; }
    },

    ADAMANT{
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 50;
        }
        @Override
        public int ItemId() {
            return 1357;
        }
        public String Name() { return "Adamant axe"; }
    },

    RUNE{
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 60;
        }
        @Override
        public int ItemId() {
            return 1359;
        }
        public String Name() { return "Rune axe"; }
    },

    DRAGON {
        @Override
        public boolean isMembers() {
            return true;
        }

        @Override
        public int requiredLevel() {
            return 75;
        }

        @Override
        public int ItemId() {
            return 6739;
        }
        public String Name() { return "Dragon axe"; }
    },

    INFERNAL {
        @Override
        public boolean isMembers() {
            return true;
        }

        @Override
        public int requiredLevel() {
            return 75;
        }

        @Override
        public int ItemId() {
            return 13241;
        }
        public String Name() { return "Infernal axe"; }
    },

    INFERNAL_UNCHARGED {
        @Override
        public boolean isMembers() {
            return true;
        }

        @Override
        public int requiredLevel() {
            return 75;
        }

        @Override
        public int ItemId() {
            return 13242;
        }
        public String Name() { return "Infernal axe (uncharged)"; }
    };

    public abstract boolean isMembers();
    public abstract int requiredLevel();
    public abstract int ItemId();
    public abstract String Name();
}
