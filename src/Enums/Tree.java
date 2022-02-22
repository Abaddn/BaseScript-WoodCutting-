package Enums;

import Misc.Named;

public enum Tree implements Named {
    NORMAL {
        @Override
        public String getName() { return "Normal"; }
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 1;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1276, 1278, 1279
            };
        }
    },

    Oak {
        @Override
        public String getName() { return "Oak"; }
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 15;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1751
            };
        }
    },

    WILLOW{
        @Override
        public String getName() { return "Willow"; }
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 30;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1756, 1758, 1760, 1750
            };
        }
    },

    TEAK{
        @Override
        public String getName() { return "Teak"; }
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 35;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    9036
            };
        }
    },

    MAPLE{
        @Override
        public String getName() { return "Maple"; }
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 45;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1759
            };
        }
    },

    MAHOGANY{
        @Override
        public String getName() { return "Mahogany"; }
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 50;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    9034
            };
        }
    },

    YEW{
        @Override
        public String getName() { return "Yew"; }
        @Override
        public boolean isMembers() {
            return false;
        }
        @Override
        public int requiredLevel() {
            return 60;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1753, 1754
            };
        }
    },

    MAGIC{
        @Override
        public String getName() { return "Magic"; }
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 75;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    1761
            };
        }
    },

    REDWOOD{
        @Override
        public String getName() { return "Redwood"; }
        @Override
        public boolean isMembers() {
            return true;
        }
        @Override
        public int requiredLevel() {
            return 90;
        }
        @Override
        public int[] gameObjectIds() {
            return new int[] {
                    28859
            };
        }
    };

    public abstract boolean isMembers();
    public abstract int requiredLevel();
    public abstract int[] gameObjectIds();
}
