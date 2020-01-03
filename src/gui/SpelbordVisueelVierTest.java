package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public abstract class SpelbordVisueelVierTest extends Pane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView r00;
    protected final ImageView r01;
    protected final ImageView r02;
    protected final ImageView r03;
    protected final ImageView r10;
    protected final ImageView r11;
    protected final ImageView r12;
    protected final ImageView r13;
    protected final ImageView r20;
    protected final ImageView r21;
    protected final ImageView r22;
    protected final ImageView r23;
    protected final ImageView r30;
    protected final ImageView r31;
    protected final ImageView r32;
    protected final ImageView r33;
    protected final ImageView r40;
    protected final ImageView r41;
    protected final ImageView r42;
    protected final ImageView r43;
    protected final ImageView r50;
    protected final ImageView r51;
    protected final ImageView r52;
    protected final ImageView r53;
    protected final ImageView r60;
    protected final ImageView r61;
    protected final ImageView r62;
    protected final ImageView r63;
    protected final ImageView r70;
    protected final ImageView r71;
    protected final ImageView r72;
    protected final ImageView r73;
    protected final ImageView r80;
    protected final ImageView r81;
    protected final ImageView r82;
    protected final ImageView r83;
    protected final ImageView r90;
    protected final ImageView r91;
    protected final ImageView r92;
    protected final ImageView r93;
    protected final ImageView r100;
    protected final ImageView r101;
    protected final ImageView r102;
    protected final ImageView r103;
    protected final ImageView r110;
    protected final ImageView r111;
    protected final ImageView r112;
    protected final ImageView r113;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView rood;
    protected final ImageView paars;
    protected final ImageView groen;
    protected final ImageView cyaan;
    protected final ImageView bruin;
    protected final ImageView oranje;
    protected final ImageView blauw;
    protected final ImageView geel;
    protected final Button btnPoging;
    protected final ImageView p0;
    protected final ImageView p1;
    protected final ImageView p2;
    protected final ImageView p3;
    protected final Circle leeg;
    protected final Button btnClear;
    protected final ImageView v00;
    protected final ImageView v01;
    protected final ImageView v02;
    protected final ImageView v03;
    protected final ImageView v10;
    protected final ImageView v11;
    protected final ImageView v12;
    protected final ImageView v13;
    protected final ImageView v20;
    protected final ImageView v21;
    protected final ImageView v22;
    protected final ImageView v23;
    protected final ImageView v30;
    protected final ImageView v31;
    protected final ImageView v32;
    protected final ImageView v33;
    protected final ImageView v40;
    protected final ImageView v41;
    protected final ImageView v42;
    protected final ImageView v43;
    protected final ImageView v50;
    protected final ImageView v51;
    protected final ImageView v52;
    protected final ImageView v53;
    protected final ImageView v60;
    protected final ImageView v61;
    protected final ImageView v62;
    protected final ImageView v63;
    protected final ImageView v70;
    protected final ImageView v71;
    protected final ImageView v72;
    protected final ImageView v73;
    protected final ImageView v80;
    protected final ImageView v81;
    protected final ImageView v82;
    protected final ImageView v83;
    protected final ImageView v90;
    protected final ImageView v91;
    protected final ImageView v92;
    protected final ImageView v93;
    protected final ImageView v100;
    protected final ImageView v101;
    protected final ImageView v102;
    protected final ImageView v103;
    protected final ImageView v110;
    protected final ImageView v111;
    protected final ImageView v112;
    protected final ImageView v113;
    protected final Button btnSave;
    protected final TextField txtSpelnaam;

    public SpelbordVisueelVierTest() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        r00 = new ImageView();
        r01 = new ImageView();
        r02 = new ImageView();
        r03 = new ImageView();
        r10 = new ImageView();
        r11 = new ImageView();
        r12 = new ImageView();
        r13 = new ImageView();
        r20 = new ImageView();
        r21 = new ImageView();
        r22 = new ImageView();
        r23 = new ImageView();
        r30 = new ImageView();
        r31 = new ImageView();
        r32 = new ImageView();
        r33 = new ImageView();
        r40 = new ImageView();
        r41 = new ImageView();
        r42 = new ImageView();
        r43 = new ImageView();
        r50 = new ImageView();
        r51 = new ImageView();
        r52 = new ImageView();
        r53 = new ImageView();
        r60 = new ImageView();
        r61 = new ImageView();
        r62 = new ImageView();
        r63 = new ImageView();
        r70 = new ImageView();
        r71 = new ImageView();
        r72 = new ImageView();
        r73 = new ImageView();
        r80 = new ImageView();
        r81 = new ImageView();
        r82 = new ImageView();
        r83 = new ImageView();
        r90 = new ImageView();
        r91 = new ImageView();
        r92 = new ImageView();
        r93 = new ImageView();
        r100 = new ImageView();
        r101 = new ImageView();
        r102 = new ImageView();
        r103 = new ImageView();
        r110 = new ImageView();
        r111 = new ImageView();
        r112 = new ImageView();
        r113 = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        rood = new ImageView();
        paars = new ImageView();
        groen = new ImageView();
        cyaan = new ImageView();
        bruin = new ImageView();
        oranje = new ImageView();
        blauw = new ImageView();
        geel = new ImageView();
        btnPoging = new Button();
        p0 = new ImageView();
        p1 = new ImageView();
        p2 = new ImageView();
        p3 = new ImageView();
        leeg = new Circle();
        btnClear = new Button();
        v00 = new ImageView();
        v01 = new ImageView();
        v02 = new ImageView();
        v03 = new ImageView();
        v10 = new ImageView();
        v11 = new ImageView();
        v12 = new ImageView();
        v13 = new ImageView();
        v20 = new ImageView();
        v21 = new ImageView();
        v22 = new ImageView();
        v23 = new ImageView();
        v30 = new ImageView();
        v31 = new ImageView();
        v32 = new ImageView();
        v33 = new ImageView();
        v40 = new ImageView();
        v41 = new ImageView();
        v42 = new ImageView();
        v43 = new ImageView();
        v50 = new ImageView();
        v51 = new ImageView();
        v52 = new ImageView();
        v53 = new ImageView();
        v60 = new ImageView();
        v61 = new ImageView();
        v62 = new ImageView();
        v63 = new ImageView();
        v70 = new ImageView();
        v71 = new ImageView();
        v72 = new ImageView();
        v73 = new ImageView();
        v80 = new ImageView();
        v81 = new ImageView();
        v82 = new ImageView();
        v83 = new ImageView();
        v90 = new ImageView();
        v91 = new ImageView();
        v92 = new ImageView();
        v93 = new ImageView();
        v100 = new ImageView();
        v101 = new ImageView();
        v102 = new ImageView();
        v103 = new ImageView();
        v110 = new ImageView();
        v111 = new ImageView();
        v112 = new ImageView();
        v113 = new ImageView();
        btnSave = new Button();
        txtSpelnaam = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(751.0);
        setPrefWidth(1228.0);

        imageView.setFitHeight(694.0);
        imageView.setFitWidth(652.0);
        imageView.setLayoutX(160.0);
        imageView.setLayoutY(9.0);
        imageView.setImage(new Image(getClass().getResource("../imgs2/Mastermind4.png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#0b2474"));
        rectangle.setHeight(572.0);
        rectangle.setLayoutX(824.0);
        rectangle.setLayoutY(-1.0);
        rectangle.setOpacity(0.5);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(331.0);

        r00.setFitHeight(23.0);
        r00.setFitWidth(23.0);
        r00.setLayoutX(362.0);
        r00.setLayoutY(27.0);
        r00.setPickOnBounds(true);
        r00.setPreserveRatio(true);

        r01.setFitHeight(23.0);
        r01.setFitWidth(23.0);
        r01.setLayoutX(402.0);
        r01.setLayoutY(28.0);
        r01.setPickOnBounds(true);
        r01.setPreserveRatio(true);

        r02.setFitHeight(23.0);
        r02.setFitWidth(23.0);
        r02.setLayoutX(443.0);
        r02.setLayoutY(28.0);
        r02.setPickOnBounds(true);
        r02.setPreserveRatio(true);

        r03.setFitHeight(23.0);
        r03.setFitWidth(23.0);
        r03.setLayoutX(483.0);
        r03.setLayoutY(29.0);
        r03.setPickOnBounds(true);
        r03.setPreserveRatio(true);

        r10.setFitHeight(23.0);
        r10.setFitWidth(23.0);
        r10.setLayoutX(357.0);
        r10.setLayoutY(54.0);
        r10.setPickOnBounds(true);
        r10.setPreserveRatio(true);

        r11.setFitHeight(23.0);
        r11.setFitWidth(23.0);
        r11.setLayoutX(399.0);
        r11.setLayoutY(54.0);
        r11.setPickOnBounds(true);
        r11.setPreserveRatio(true);

        r12.setFitHeight(23.0);
        r12.setFitWidth(23.0);
        r12.setLayoutX(441.0);
        r12.setLayoutY(55.0);
        r12.setPickOnBounds(true);
        r12.setPreserveRatio(true);

        r13.setFitHeight(23.0);
        r13.setFitWidth(23.0);
        r13.setLayoutX(483.0);
        r13.setLayoutY(53.0);
        r13.setPickOnBounds(true);
        r13.setPreserveRatio(true);

        r20.setFitHeight(23.0);
        r20.setFitWidth(23.0);
        r20.setLayoutX(351.0);
        r20.setLayoutY(83.0);
        r20.setPickOnBounds(true);
        r20.setPreserveRatio(true);

        r21.setFitHeight(23.0);
        r21.setFitWidth(23.0);
        r21.setLayoutX(394.0);
        r21.setLayoutY(82.0);
        r21.setPickOnBounds(true);
        r21.setPreserveRatio(true);

        r22.setFitHeight(23.0);
        r22.setFitWidth(23.0);
        r22.setLayoutX(439.0);
        r22.setLayoutY(83.0);
        r22.setPickOnBounds(true);
        r22.setPreserveRatio(true);

        r23.setFitHeight(23.0);
        r23.setFitWidth(23.0);
        r23.setLayoutX(483.0);
        r23.setLayoutY(82.0);
        r23.setPickOnBounds(true);
        r23.setPreserveRatio(true);

        r30.setFitHeight(23.0);
        r30.setFitWidth(23.0);
        r30.setLayoutX(346.0);
        r30.setLayoutY(117.0);
        r30.setPickOnBounds(true);
        r30.setPreserveRatio(true);

        r31.setFitHeight(23.0);
        r31.setFitWidth(23.0);
        r31.setLayoutX(390.0);
        r31.setLayoutY(118.0);
        r31.setPickOnBounds(true);
        r31.setPreserveRatio(true);

        r32.setFitHeight(23.0);
        r32.setFitWidth(23.0);
        r32.setLayoutX(436.0);
        r32.setLayoutY(119.0);
        r32.setPickOnBounds(true);
        r32.setPreserveRatio(true);

        r33.setFitHeight(23.0);
        r33.setFitWidth(23.0);
        r33.setLayoutX(481.0);
        r33.setLayoutY(118.0);
        r33.setPickOnBounds(true);
        r33.setPreserveRatio(true);

        r40.setFitHeight(30.0);
        r40.setFitWidth(30.0);
        r40.setLayoutX(336.0);
        r40.setLayoutY(152.0);
        r40.setPickOnBounds(true);
        r40.setPreserveRatio(true);

        r41.setFitHeight(30.0);
        r41.setFitWidth(30.0);
        r41.setLayoutX(383.0);
        r41.setLayoutY(152.0);
        r41.setPickOnBounds(true);
        r41.setPreserveRatio(true);

        r42.setFitHeight(30.0);
        r42.setFitWidth(30.0);
        r42.setLayoutX(430.0);
        r42.setLayoutY(153.0);
        r42.setPickOnBounds(true);
        r42.setPreserveRatio(true);

        r43.setFitHeight(30.0);
        r43.setFitWidth(30.0);
        r43.setLayoutX(477.0);
        r43.setLayoutY(155.0);
        r43.setPickOnBounds(true);
        r43.setPreserveRatio(true);

        r50.setFitHeight(30.0);
        r50.setFitWidth(30.0);
        r50.setLayoutX(330.0);
        r50.setLayoutY(195.0);
        r50.setPickOnBounds(true);
        r50.setPreserveRatio(true);

        r51.setFitHeight(30.0);
        r51.setFitWidth(30.0);
        r51.setLayoutX(380.0);
        r51.setLayoutY(193.0);
        r51.setPickOnBounds(true);
        r51.setPreserveRatio(true);

        r52.setFitHeight(30.0);
        r52.setFitWidth(30.0);
        r52.setLayoutX(429.0);
        r52.setLayoutY(193.0);
        r52.setPickOnBounds(true);
        r52.setPreserveRatio(true);

        r53.setFitHeight(30.0);
        r53.setFitWidth(30.0);
        r53.setLayoutX(478.0);
        r53.setLayoutY(194.0);
        r53.setPickOnBounds(true);
        r53.setPreserveRatio(true);

        r60.setFitHeight(30.0);
        r60.setFitWidth(30.0);
        r60.setLayoutX(322.0);
        r60.setLayoutY(234.0);
        r60.setPickOnBounds(true);
        r60.setPreserveRatio(true);

        r61.setFitHeight(30.0);
        r61.setFitWidth(30.0);
        r61.setLayoutX(374.0);
        r61.setLayoutY(233.0);
        r61.setPickOnBounds(true);
        r61.setPreserveRatio(true);

        r62.setFitHeight(30.0);
        r62.setFitWidth(30.0);
        r62.setLayoutX(425.0);
        r62.setLayoutY(234.0);
        r62.setPickOnBounds(true);
        r62.setPreserveRatio(true);

        r63.setFitHeight(30.0);
        r63.setFitWidth(30.0);
        r63.setLayoutX(478.0);
        r63.setLayoutY(233.0);
        r63.setPickOnBounds(true);
        r63.setPreserveRatio(true);

        r70.setFitHeight(30.0);
        r70.setFitWidth(30.0);
        r70.setLayoutX(316.0);
        r70.setLayoutY(274.0);
        r70.setPickOnBounds(true);
        r70.setPreserveRatio(true);

        r71.setFitHeight(30.0);
        r71.setFitWidth(30.0);
        r71.setLayoutX(369.0);
        r71.setLayoutY(272.0);
        r71.setPickOnBounds(true);
        r71.setPreserveRatio(true);

        r72.setFitHeight(30.0);
        r72.setFitWidth(30.0);
        r72.setLayoutX(424.0);
        r72.setLayoutY(274.0);
        r72.setPickOnBounds(true);
        r72.setPreserveRatio(true);

        r73.setFitHeight(30.0);
        r73.setFitWidth(30.0);
        r73.setLayoutX(477.0);
        r73.setLayoutY(273.0);
        r73.setPickOnBounds(true);
        r73.setPreserveRatio(true);

        r80.setFitHeight(38.0);
        r80.setFitWidth(38.0);
        r80.setLayoutX(305.0);
        r80.setLayoutY(314.0);
        r80.setPickOnBounds(true);
        r80.setPreserveRatio(true);

        r81.setFitHeight(38.0);
        r81.setFitWidth(38.0);
        r81.setLayoutX(361.0);
        r81.setLayoutY(314.0);
        r81.setPickOnBounds(true);
        r81.setPreserveRatio(true);

        r82.setFitHeight(38.0);
        r82.setFitWidth(38.0);
        r82.setLayoutX(417.0);
        r82.setLayoutY(314.0);
        r82.setPickOnBounds(true);
        r82.setPreserveRatio(true);

        r83.setFitHeight(38.0);
        r83.setFitWidth(38.0);
        r83.setLayoutX(473.0);
        r83.setLayoutY(314.0);
        r83.setPickOnBounds(true);
        r83.setPreserveRatio(true);

        r90.setFitHeight(38.0);
        r90.setFitWidth(38.0);
        r90.setLayoutX(297.0);
        r90.setLayoutY(364.0);
        r90.setPickOnBounds(true);
        r90.setPreserveRatio(true);

        r91.setFitHeight(38.0);
        r91.setFitWidth(38.0);
        r91.setLayoutX(356.0);
        r91.setLayoutY(364.0);
        r91.setPickOnBounds(true);
        r91.setPreserveRatio(true);

        r92.setFitHeight(38.0);
        r92.setFitWidth(38.0);
        r92.setLayoutX(413.0);
        r92.setLayoutY(364.0);
        r92.setPickOnBounds(true);
        r92.setPreserveRatio(true);

        r93.setFitHeight(38.0);
        r93.setFitWidth(38.0);
        r93.setLayoutX(473.0);
        r93.setLayoutY(364.0);
        r93.setPickOnBounds(true);
        r93.setPreserveRatio(true);

        r100.setFitHeight(38.0);
        r100.setFitWidth(38.0);
        r100.setLayoutX(290.0);
        r100.setLayoutY(415.0);
        r100.setPickOnBounds(true);
        r100.setPreserveRatio(true);

        r101.setFitHeight(38.0);
        r101.setFitWidth(38.0);
        r101.setLayoutX(350.0);
        r101.setLayoutY(415.0);
        r101.setPickOnBounds(true);
        r101.setPreserveRatio(true);

        r102.setFitHeight(38.0);
        r102.setFitWidth(38.0);
        r102.setLayoutX(411.0);
        r102.setLayoutY(415.0);
        r102.setPickOnBounds(true);
        r102.setPreserveRatio(true);

        r103.setFitHeight(38.0);
        r103.setFitWidth(38.0);
        r103.setLayoutX(471.0);
        r103.setLayoutY(415.0);
        r103.setPickOnBounds(true);
        r103.setPreserveRatio(true);

        r110.setFitHeight(45.0);
        r110.setFitWidth(45.0);
        r110.setLayoutX(278.0);
        r110.setLayoutY(469.0);
        r110.setPickOnBounds(true);
        r110.setPreserveRatio(true);

        r111.setFitHeight(45.0);
        r111.setFitWidth(45.0);
        r111.setLayoutX(340.0);
        r111.setLayoutY(469.0);
        r111.setPickOnBounds(true);
        r111.setPreserveRatio(true);

        r112.setFitHeight(45.0);
        r112.setFitWidth(45.0);
        r112.setLayoutX(404.0);
        r112.setLayoutY(469.0);
        r112.setPickOnBounds(true);
        r112.setPreserveRatio(true);

        r113.setFitHeight(45.0);
        r113.setFitWidth(45.0);
        r113.setLayoutX(467.0);
        r113.setLayoutY(469.0);
        r113.setPickOnBounds(true);
        r113.setPreserveRatio(true);

        imageView0.setFitHeight(45.0);
        imageView0.setFitWidth(45.0);
        imageView0.setLayoutX(882.0);
        imageView0.setLayoutY(18.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        imageView1.setFitHeight(45.0);
        imageView1.setFitWidth(45.0);
        imageView1.setLayoutX(946.0);
        imageView1.setLayoutY(18.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        rood.setFitHeight(45.0);
        rood.setFitWidth(45.0);
        rood.setLayoutX(892.0);
        rood.setLayoutY(29.0);
        rood.setPickOnBounds(true);
        rood.setPreserveRatio(true);
        rood.setImage(new Image(getClass().getResource("../imgs2/Rood.png").toExternalForm()));

        paars.setFitHeight(45.0);
        paars.setFitWidth(45.0);
        paars.setLayoutX(1053.0);
        paars.setLayoutY(28.0);
        paars.setPickOnBounds(true);
        paars.setPreserveRatio(true);
        paars.setImage(new Image(getClass().getResource("../imgs2/Paars.png").toExternalForm()));

        groen.setFitHeight(45.0);
        groen.setFitWidth(45.0);
        groen.setLayoutX(898.0);
        groen.setLayoutY(84.0);
        groen.setPickOnBounds(true);
        groen.setPreserveRatio(true);
        groen.setImage(new Image(getClass().getResource("../imgs2/Groen.png").toExternalForm()));

        cyaan.setFitHeight(45.0);
        cyaan.setFitWidth(45.0);
        cyaan.setLayoutX(943.0);
        cyaan.setLayoutY(89.0);
        cyaan.setPickOnBounds(true);
        cyaan.setPreserveRatio(true);
        cyaan.setImage(new Image(getClass().getResource("../imgs2/Cyaan.png").toExternalForm()));

        bruin.setFitHeight(45.0);
        bruin.setFitWidth(45.0);
        bruin.setLayoutX(1001.0);
        bruin.setLayoutY(83.0);
        bruin.setPickOnBounds(true);
        bruin.setPreserveRatio(true);
        bruin.setImage(new Image(getClass().getResource("../imgs2/Bruin.png").toExternalForm()));

        oranje.setFitHeight(45.0);
        oranje.setFitWidth(45.0);
        oranje.setLayoutX(1050.0);
        oranje.setLayoutY(83.0);
        oranje.setPickOnBounds(true);
        oranje.setPreserveRatio(true);
        oranje.setImage(new Image(getClass().getResource("../imgs2/Oranje.png").toExternalForm()));

        blauw.setFitHeight(45.0);
        blauw.setFitWidth(45.0);
        blauw.setLayoutX(946.0);
        blauw.setLayoutY(28.0);
        blauw.setPickOnBounds(true);
        blauw.setPreserveRatio(true);
        blauw.setImage(new Image(getClass().getResource("../imgs2/Blauw.png").toExternalForm()));

        geel.setFitHeight(45.0);
        geel.setFitWidth(45.0);
        geel.setLayoutX(997.0);
        geel.setLayoutY(31.0);
        geel.setPickOnBounds(true);
        geel.setPreserveRatio(true);
        geel.setImage(new Image(getClass().getResource("../imgs2/Geel.png").toExternalForm()));

        btnPoging.setLayoutX(884.0);
        btnPoging.setLayoutY(190.0);
        btnPoging.setMnemonicParsing(false);
        btnPoging.setPrefHeight(66.0);
        btnPoging.setPrefWidth(215.0);
        btnPoging.setText("Poging");

        p0.setFitHeight(45.0);
        p0.setFitWidth(45.0);
        p0.setLayoutX(268.0);
        p0.setLayoutY(609.0);
        p0.setPickOnBounds(true);
        p0.setPreserveRatio(true);

        p1.setFitHeight(45.0);
        p1.setFitWidth(45.0);
        p1.setLayoutX(334.0);
        p1.setLayoutY(609.0);
        p1.setPickOnBounds(true);
        p1.setPreserveRatio(true);

        p2.setFitHeight(45.0);
        p2.setFitWidth(45.0);
        p2.setLayoutX(400.0);
        p2.setLayoutY(609.0);
        p2.setPickOnBounds(true);
        p2.setPreserveRatio(true);

        p3.setFitHeight(45.0);
        p3.setFitWidth(45.0);
        p3.setLayoutX(467.0);
        p3.setLayoutY(609.0);
        p3.setPickOnBounds(true);
        p3.setPreserveRatio(true);

        leeg.setLayoutX(991.0);
        leeg.setLayoutY(155.0);
        leeg.setOpacity(0.5);
        leeg.setRadius(19.0);
        leeg.setStroke(javafx.scene.paint.Color.BLACK);
        leeg.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        leeg.setStrokeWidth(2.0);

        btnClear.setLayoutX(884.0);
        btnClear.setLayoutY(270.0);
        btnClear.setMnemonicParsing(false);
        btnClear.setPrefHeight(66.0);
        btnClear.setPrefWidth(215.0);
        btnClear.setText("Clear");

        v00.setFitHeight(9.0);
        v00.setFitWidth(12.0);
        v00.setLayoutX(517.0);
        v00.setLayoutY(34.0);
        v00.setPickOnBounds(true);
        v00.setPreserveRatio(true);

        v01.setFitHeight(9.0);
        v01.setFitWidth(12.0);
        v01.setLayoutX(536.0);
        v01.setLayoutY(34.0);
        v01.setPickOnBounds(true);
        v01.setPreserveRatio(true);

        v02.setFitHeight(9.0);
        v02.setFitWidth(12.0);
        v02.setLayoutX(517.0);
        v02.setLayoutY(44.0);
        v02.setPickOnBounds(true);
        v02.setPreserveRatio(true);

        v03.setFitHeight(9.0);
        v03.setFitWidth(12.0);
        v03.setLayoutX(537.0);
        v03.setLayoutY(45.0);
        v03.setPickOnBounds(true);
        v03.setPreserveRatio(true);

        v10.setFitHeight(9.0);
        v10.setFitWidth(12.0);
        v10.setLayoutX(517.0);
        v10.setLayoutY(59.0);
        v10.setPickOnBounds(true);
        v10.setPreserveRatio(true);

        v11.setFitHeight(9.0);
        v11.setFitWidth(12.0);
        v11.setLayoutX(538.0);
        v11.setLayoutY(60.0);
        v11.setPickOnBounds(true);
        v11.setPreserveRatio(true);

        v12.setFitHeight(9.0);
        v12.setFitWidth(12.0);
        v12.setLayoutX(518.0);
        v12.setLayoutY(70.0);
        v12.setPickOnBounds(true);
        v12.setPreserveRatio(true);

        v13.setFitHeight(9.0);
        v13.setFitWidth(12.0);
        v13.setLayoutX(538.0);
        v13.setLayoutY(71.0);
        v13.setPickOnBounds(true);
        v13.setPreserveRatio(true);

        v20.setFitHeight(9.0);
        v20.setFitWidth(12.0);
        v20.setLayoutX(519.0);
        v20.setLayoutY(86.0);
        v20.setPickOnBounds(true);
        v20.setPreserveRatio(true);

        v21.setFitHeight(9.0);
        v21.setFitWidth(12.0);
        v21.setLayoutX(540.0);
        v21.setLayoutY(86.0);
        v21.setPickOnBounds(true);
        v21.setPreserveRatio(true);

        v22.setFitHeight(9.0);
        v22.setFitWidth(12.0);
        v22.setLayoutX(518.0);
        v22.setLayoutY(100.0);
        v22.setPickOnBounds(true);
        v22.setPreserveRatio(true);

        v23.setFitHeight(9.0);
        v23.setFitWidth(12.0);
        v23.setLayoutX(540.0);
        v23.setLayoutY(100.0);
        v23.setPickOnBounds(true);
        v23.setPreserveRatio(true);

        v30.setFitHeight(9.0);
        v30.setFitWidth(13.0);
        v30.setLayoutX(518.0);
        v30.setLayoutY(121.0);
        v30.setPickOnBounds(true);
        v30.setPreserveRatio(true);

        v31.setFitHeight(9.0);
        v31.setFitWidth(12.0);
        v31.setLayoutX(542.0);
        v31.setLayoutY(121.0);
        v31.setPickOnBounds(true);
        v31.setPreserveRatio(true);

        v32.setFitHeight(9.0);
        v32.setFitWidth(14.0);
        v32.setLayoutX(519.0);
        v32.setLayoutY(135.0);
        v32.setPickOnBounds(true);
        v32.setPreserveRatio(true);

        v33.setFitHeight(9.0);
        v33.setFitWidth(14.0);
        v33.setLayoutX(542.0);
        v33.setLayoutY(136.0);
        v33.setPickOnBounds(true);
        v33.setPreserveRatio(true);

        v40.setFitHeight(9.0);
        v40.setFitWidth(12.0);
        v40.setLayoutX(520.0);
        v40.setLayoutY(158.0);
        v40.setPickOnBounds(true);
        v40.setPreserveRatio(true);

        v41.setFitHeight(9.0);
        v41.setFitWidth(12.0);
        v41.setLayoutX(544.0);
        v41.setLayoutY(159.0);
        v41.setPickOnBounds(true);
        v41.setPreserveRatio(true);

        v42.setFitHeight(9.0);
        v42.setFitWidth(14.0);
        v42.setLayoutX(520.0);
        v42.setLayoutY(174.0);
        v42.setPickOnBounds(true);
        v42.setPreserveRatio(true);

        v43.setFitHeight(9.0);
        v43.setFitWidth(14.0);
        v43.setLayoutX(543.0);
        v43.setLayoutY(174.0);
        v43.setPickOnBounds(true);
        v43.setPreserveRatio(true);

        v50.setFitHeight(9.0);
        v50.setFitWidth(14.0);
        v50.setLayoutX(521.0);
        v50.setLayoutY(199.0);
        v50.setPickOnBounds(true);
        v50.setPreserveRatio(true);

        v51.setFitHeight(9.0);
        v51.setFitWidth(14.0);
        v51.setLayoutX(544.0);
        v51.setLayoutY(199.0);
        v51.setPickOnBounds(true);
        v51.setPreserveRatio(true);

        v52.setFitHeight(9.0);
        v52.setFitWidth(14.0);
        v52.setLayoutX(521.0);
        v52.setLayoutY(216.0);
        v52.setPickOnBounds(true);
        v52.setPreserveRatio(true);

        v53.setFitHeight(9.0);
        v53.setFitWidth(14.0);
        v53.setLayoutX(545.0);
        v53.setLayoutY(216.0);
        v53.setPickOnBounds(true);
        v53.setPreserveRatio(true);

        v60.setFitHeight(9.0);
        v60.setFitWidth(14.0);
        v60.setLayoutX(521.0);
        v60.setLayoutY(239.0);
        v60.setPickOnBounds(true);
        v60.setPreserveRatio(true);

        v61.setFitHeight(9.0);
        v61.setFitWidth(14.0);
        v61.setLayoutX(547.0);
        v61.setLayoutY(239.0);
        v61.setPickOnBounds(true);
        v61.setPreserveRatio(true);

        v62.setFitHeight(9.0);
        v62.setFitWidth(14.0);
        v62.setLayoutX(522.0);
        v62.setLayoutY(254.0);
        v62.setPickOnBounds(true);
        v62.setPreserveRatio(true);

        v63.setFitHeight(9.0);
        v63.setFitWidth(14.0);
        v63.setLayoutX(549.0);
        v63.setLayoutY(255.0);
        v63.setPickOnBounds(true);
        v63.setPreserveRatio(true);

        v70.setFitHeight(9.0);
        v70.setFitWidth(14.0);
        v70.setLayoutX(523.0);
        v70.setLayoutY(279.0);
        v70.setPickOnBounds(true);
        v70.setPreserveRatio(true);

        v71.setFitHeight(9.0);
        v71.setFitWidth(14.0);
        v71.setLayoutX(550.0);
        v71.setLayoutY(280.0);
        v71.setPickOnBounds(true);
        v71.setPreserveRatio(true);

        v72.setFitHeight(9.0);
        v72.setFitWidth(14.0);
        v72.setLayoutX(523.0);
        v72.setLayoutY(296.0);
        v72.setPickOnBounds(true);
        v72.setPreserveRatio(true);

        v73.setFitHeight(9.0);
        v73.setFitWidth(14.0);
        v73.setLayoutX(550.0);
        v73.setLayoutY(296.0);
        v73.setPickOnBounds(true);
        v73.setPreserveRatio(true);

        v80.setFitHeight(9.0);
        v80.setFitWidth(14.0);
        v80.setLayoutX(524.0);
        v80.setLayoutY(322.0);
        v80.setPickOnBounds(true);
        v80.setPreserveRatio(true);

        v81.setFitHeight(9.0);
        v81.setFitWidth(14.0);
        v81.setLayoutX(552.0);
        v81.setLayoutY(323.0);
        v81.setPickOnBounds(true);
        v81.setPreserveRatio(true);

        v82.setFitHeight(9.0);
        v82.setFitWidth(14.0);
        v82.setLayoutX(525.0);
        v82.setLayoutY(341.0);
        v82.setPickOnBounds(true);
        v82.setPreserveRatio(true);

        v83.setFitHeight(9.0);
        v83.setFitWidth(14.0);
        v83.setLayoutX(553.0);
        v83.setLayoutY(341.0);
        v83.setPickOnBounds(true);
        v83.setPreserveRatio(true);

        v90.setFitHeight(9.0);
        v90.setFitWidth(14.0);
        v90.setLayoutX(525.0);
        v90.setLayoutY(370.0);
        v90.setPickOnBounds(true);
        v90.setPreserveRatio(true);

        v91.setFitHeight(9.0);
        v91.setFitWidth(14.0);
        v91.setLayoutX(554.0);
        v91.setLayoutY(370.0);
        v91.setPickOnBounds(true);
        v91.setPreserveRatio(true);

        v92.setFitHeight(9.0);
        v92.setFitWidth(14.0);
        v92.setLayoutX(526.0);
        v92.setLayoutY(390.0);
        v92.setPickOnBounds(true);
        v92.setPreserveRatio(true);

        v93.setFitHeight(9.0);
        v93.setFitWidth(14.0);
        v93.setLayoutX(555.0);
        v93.setLayoutY(391.0);
        v93.setPickOnBounds(true);
        v93.setPreserveRatio(true);

        v100.setFitHeight(9.0);
        v100.setFitWidth(14.0);
        v100.setLayoutX(527.0);
        v100.setLayoutY(421.0);
        v100.setPickOnBounds(true);
        v100.setPreserveRatio(true);

        v101.setFitHeight(9.0);
        v101.setFitWidth(14.0);
        v101.setLayoutX(556.0);
        v101.setLayoutY(422.0);
        v101.setPickOnBounds(true);
        v101.setPreserveRatio(true);

        v102.setFitHeight(9.0);
        v102.setFitWidth(14.0);
        v102.setLayoutX(527.0);
        v102.setLayoutY(443.0);
        v102.setPickOnBounds(true);
        v102.setPreserveRatio(true);

        v103.setFitHeight(9.0);
        v103.setFitWidth(14.0);
        v103.setLayoutX(558.0);
        v103.setLayoutY(443.0);
        v103.setPickOnBounds(true);
        v103.setPreserveRatio(true);

        v110.setFitHeight(9.0);
        v110.setFitWidth(14.0);
        v110.setLayoutX(528.0);
        v110.setLayoutY(477.0);
        v110.setPickOnBounds(true);
        v110.setPreserveRatio(true);

        v111.setFitHeight(9.0);
        v111.setFitWidth(14.0);
        v111.setLayoutX(558.0);
        v111.setLayoutY(478.0);
        v111.setPickOnBounds(true);
        v111.setPreserveRatio(true);

        v112.setFitHeight(9.0);
        v112.setFitWidth(14.0);
        v112.setLayoutX(528.0);
        v112.setLayoutY(501.0);
        v112.setPickOnBounds(true);
        v112.setPreserveRatio(true);

        v113.setFitHeight(9.0);
        v113.setFitWidth(14.0);
        v113.setLayoutX(559.0);
        v113.setLayoutY(501.0);
        v113.setPickOnBounds(true);
        v113.setPreserveRatio(true);

        btnSave.setLayoutX(882.0);
        btnSave.setLayoutY(350.0);
        btnSave.setMnemonicParsing(false);
        btnSave.setPrefHeight(66.0);
        btnSave.setPrefWidth(215.0);
        btnSave.setText("Save");

        txtSpelnaam.setLayoutX(884.0);
        txtSpelnaam.setLayoutY(440.0);
        txtSpelnaam.setPrefHeight(25.0);
        txtSpelnaam.setPrefWidth(215.0);

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(r00);
        getChildren().add(r01);
        getChildren().add(r02);
        getChildren().add(r03);
        getChildren().add(r10);
        getChildren().add(r11);
        getChildren().add(r12);
        getChildren().add(r13);
        getChildren().add(r20);
        getChildren().add(r21);
        getChildren().add(r22);
        getChildren().add(r23);
        getChildren().add(r30);
        getChildren().add(r31);
        getChildren().add(r32);
        getChildren().add(r33);
        getChildren().add(r40);
        getChildren().add(r41);
        getChildren().add(r42);
        getChildren().add(r43);
        getChildren().add(r50);
        getChildren().add(r51);
        getChildren().add(r52);
        getChildren().add(r53);
        getChildren().add(r60);
        getChildren().add(r61);
        getChildren().add(r62);
        getChildren().add(r63);
        getChildren().add(r70);
        getChildren().add(r71);
        getChildren().add(r72);
        getChildren().add(r73);
        getChildren().add(r80);
        getChildren().add(r81);
        getChildren().add(r82);
        getChildren().add(r83);
        getChildren().add(r90);
        getChildren().add(r91);
        getChildren().add(r92);
        getChildren().add(r93);
        getChildren().add(r100);
        getChildren().add(r101);
        getChildren().add(r102);
        getChildren().add(r103);
        getChildren().add(r110);
        getChildren().add(r111);
        getChildren().add(r112);
        getChildren().add(r113);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(rood);
        getChildren().add(paars);
        getChildren().add(groen);
        getChildren().add(cyaan);
        getChildren().add(bruin);
        getChildren().add(oranje);
        getChildren().add(blauw);
        getChildren().add(geel);
        getChildren().add(btnPoging);
        getChildren().add(p0);
        getChildren().add(p1);
        getChildren().add(p2);
        getChildren().add(p3);
        getChildren().add(leeg);
        getChildren().add(btnClear);
        getChildren().add(v00);
        getChildren().add(v01);
        getChildren().add(v02);
        getChildren().add(v03);
        getChildren().add(v10);
        getChildren().add(v11);
        getChildren().add(v12);
        getChildren().add(v13);
        getChildren().add(v20);
        getChildren().add(v21);
        getChildren().add(v22);
        getChildren().add(v23);
        getChildren().add(v30);
        getChildren().add(v31);
        getChildren().add(v32);
        getChildren().add(v33);
        getChildren().add(v40);
        getChildren().add(v41);
        getChildren().add(v42);
        getChildren().add(v43);
        getChildren().add(v50);
        getChildren().add(v51);
        getChildren().add(v52);
        getChildren().add(v53);
        getChildren().add(v60);
        getChildren().add(v61);
        getChildren().add(v62);
        getChildren().add(v63);
        getChildren().add(v70);
        getChildren().add(v71);
        getChildren().add(v72);
        getChildren().add(v73);
        getChildren().add(v80);
        getChildren().add(v81);
        getChildren().add(v82);
        getChildren().add(v83);
        getChildren().add(v90);
        getChildren().add(v91);
        getChildren().add(v92);
        getChildren().add(v93);
        getChildren().add(v100);
        getChildren().add(v101);
        getChildren().add(v102);
        getChildren().add(v103);
        getChildren().add(v110);
        getChildren().add(v111);
        getChildren().add(v112);
        getChildren().add(v113);
        getChildren().add(btnSave);
        getChildren().add(txtSpelnaam);

    }
}
