// "Move 'return' closer to computation of the value of 'n'" "true"
class T {
    interface I {
        int call();
    }
    void f(boolean b) {
        g(() -> {
            int n = -1;
            while (true) {
                if (h()) {
                    return 1;
                }
            }
        });
    }

    void g(I i) {
        i.call();
    }

    boolean h() {
        return true;
    }
}