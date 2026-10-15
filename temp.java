class manager{
    private static manager mobj;
    private manager(){
            
    }

    static manager getManager(){
        if (mobj == null) {
            mobj = new manager();
        }
        return mobj;
    }
        }
    }


class SingleObjectDemo {
    public static void main(String[] args) {
        manager obj = manager.getManager();
    }
}
