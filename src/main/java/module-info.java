module eus.ehu.multiscenefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eus.ehu.multiscenefx to javafx.fxml;
    exports eus.ehu.multiscenefx;
}
