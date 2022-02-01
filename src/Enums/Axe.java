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
    };

    public abstract boolean isMembers();
    public abstract int requiredLevel();
    public abstract int ItemId();
}
