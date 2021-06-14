package JM;

enum BeAlgebraic {
    PLUS {
        public int action (int a, int b) {return a + b;}
    },
    MINUS {
        public int action (int a, int b) {return a - b;}
    },
    PROD {
        public int action (int a, int b) {return a * b;}
    },
    QUOT {
        public int action (int a, int b) {return a / b;}
    };
    public abstract int action (int a, int b);
}
