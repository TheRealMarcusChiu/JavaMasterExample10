package enums.simple;

public enum Days_Verbose implements Day {
    MONDAY() {
        @Override
        public Boolean isWeekend() {
            return false;
        }
    },
    TUESDAY() {
        @Override
        public Boolean isWeekend() {
            return false;
        }
    },
    WEDNESDAY() {
        @Override
        public Boolean isWeekend() {
            return false;
        }
    },
    THURSDAY() {
        @Override
        public Boolean isWeekend() {
            return false;
        }
    },
    FRIDAY() {
        @Override
        public Boolean isWeekend() {
            return false;
        }
    },
    SATURDAY() {
        @Override
        public Boolean isWeekend() {
            return true;
        }
    },
    SUNDAY() {
        @Override
        public Boolean isWeekend() {
            return true;
        }
    };

}
