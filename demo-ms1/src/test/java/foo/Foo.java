package foo;

public class Foo {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String i = "lorem ipsum123412341";
        System.out.println("i = " + i.length());
        String s = formatarTamanhoParaNoMaximo20(i);
        System.out.println(s);
        System.out.println(s.length());

        System.out.println("\"123\" = " + "123".substring(0, 5));
    }

    private static String formatarTamanhoParaNoMaximo20(String usuario) {
        if(usuario.length() <= 20) {
            return usuario;
        }
        return usuario.substring(0, 20);
    }

}
