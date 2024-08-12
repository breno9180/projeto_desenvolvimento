module projeto_desenvolvimento {
    // Exporta pacotes para outros m�dulos ou bibliotecas que possam precisar deles
    exports application;
    exports project;
    exports repository;

    // Requer m�dulos necess�rios
    requires java.sql;

    // Permite que JUnit acesse o pacote para testes
}