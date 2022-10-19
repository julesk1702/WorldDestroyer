module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;

    opens gameFiles;
    opens audio;
    opens backgrounds;
    opens sprites;
}
