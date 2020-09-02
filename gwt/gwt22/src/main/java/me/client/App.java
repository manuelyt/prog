package me.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.intendia.rxgwt2.elemento.RxElemento;
import elemental2.dom.HTMLElement;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;
import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

import static com.intendia.rxgwt2.user.RxEvents.mouseMove;
import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.EventType.mousemove;
import static org.jboss.gwt.elemento.core.EventType.touchstart;


public class App implements EntryPoint {

    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable stocksFlexTable = new FlexTable();
    private HorizontalPanel addPanel = new HorizontalPanel();
    private TextBox newSymbolTextBox = new TextBox();
    private Button addStockButton = new Button("Add");
    private Label lastUpdatedLabel = new Label();


//
//
//
//
// ____________________________________________
// ____________________________________________
// ____________________________________________
//
//
//
//
//
// https://www.vogella.com/tutorials/GWT/article.html?utm_source=twitterfeed&utm_medium=twitter
//
//
//
    public void onModuleLoad() {



        Label label = new Label("Hello GWT !!!");
        Button button = new Button("Say something");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Hello, again");
            }
        });

        RootPanel.get().add(label);
        RootPanel.get().add(button);
    }

//
//
//
// ____________________________________________
// ____________________________________________
// ____________________________________________
//
//
//
//    http://www.gwtproject.org/doc/latest/tutorial/manageevents.html//
//
//
//
//
//public void onModuleLoad() {
//
//    mainPanel.add(addStockButton);
//
//    RootPanel.get("stockList").add(mainPanel);
//
//
//
//    // Create table for stock data.
//    stocksFlexTable.setText(0, 0, "Symbol");
//    stocksFlexTable.setText(0, 1, "Price");
//    stocksFlexTable.setText(0, 2, "Change");
//    stocksFlexTable.setText(0, 3, "Remove");
//
//    // Assemble Add Stock panel.
//    addPanel.add(newSymbolTextBox);
//    addPanel.add(addStockButton);
//
//    // Assemble Main panel.
//    mainPanel.add(stocksFlexTable);
//    mainPanel.add(addPanel);
//    mainPanel.add(lastUpdatedLabel);
//
//    // Associate the Main panel with the HTML host page.
//    RootPanel.get("stockList").add(mainPanel);
//
//
//    Element root = RootPanel.get().getElement();
//
//    Element kk22 = mainPanel.getElement();
//
//
//    root.appendChild(kk22);
//
//
//    RootPanel.getBodyElement().appendChild(kk22);
//
//    // Move cursor focus to the input box.
//    newSymbolTextBox.setFocus(true);
//
//    // Listen for mouse events on the Add button.
//    addStockButton.addClickHandler(new ClickHandler() {
//        public void onClick(ClickEvent event) {
//            addStock();
//        }
//    });
//}
//
//    /**
//     * Add stock to FlexTable. Executed when the user clicks the addStockButton or
//     * presses enter in the newSymbolTextBox.
//     */
//    private void addStock() {
//    }
//

//
//
// ____________________________________________
// ____________________________________________
// ____________________________________________
//
//
//
//
//    @Override
//    public void onModuleLoad() {
//        HTMLElement el = Elements.span().style("font-weight: bold;").get();
//        Elements.body().add("mouse position: ").add(el);
//        RxElemento.fromEvent(document, mousemove)
//                .subscribe(ev -> el.textContent = ev.clientX + ", " + ev.clientY);
//    }


//
//
//
//
//
// ____________________________________________
// ____________________________________________
// ____________________________________________
//
//
//
//
//
//
//        Observable integerObservable = Observable.create(new Observable.OnSubscribe() {
//            @Override
//            public void call(Subscriber subscriber) {
//                subscriber.onNext(1);
//                subscriber.onNext(2);
//                subscriber.onNext(3);
//                subscriber.onCompleted();
//            }
//        });


//    @Override
//    public void onModuleLoad() {
//        HTMLElement el = Elements.span().style("font-weight: bold;").get();
//        Elements.body().add("mouse position: ").add(el);
//        RxElemento.fromEvent(document, mousemove)
//                .subscribe(ev -> el.textContent = ev.clientX + ", " + ev.clientY);
//    }


//        @Override
//        public void onModuleLoad() {
//
//
////                .subscribe((int[] n) -> el.textContent = n.length == 2 ? n[0] + ", " + n[1] : "")).
//
//
////        MouseAndTouch mouseAndTouch = new MouseAndTouch();
////        mouseAndTouch.events.subscribe("mouse  ", new MouseListener(new int[0]));
////        editor.events.subscribe("save", new TouchListener("admin@example.com"));
//
//
//        final boolean[] checkb = {false};
//
//        HTMLElement el = Elements.span().style("font-weight: bold;").get();
//        HTMLElement el2 = Elements.span().add("mouse position: ").get();
//        HtmlContentBuilder body = Elements.body();
//        Elements.body().add(el2).add(el);
//        RxElemento.fromEvent(document, mousemove)
//                .subscribe(ev ->
//                        {
//                            el.textContent = ev.clientX + ", " + ev.clientY;
////                            el.textContent = " ev.type : " + ev.type +" getClass : " + ev.getClass();
//                        }
//                );
//
//
////        RxElemento.fromEvent(document, mouseAndTouch)
////                .subscribe((int[] n) -> el.textContent = n.length == 2 ? n[0] + ", " + n[1] : "")).
////                .subscribe(ev -> {
////                    mouseAndTouch.moveMouse();
////                    el.textContent = ev.clientX + ", " + ev.clientY;
////                });
//
//
//        CheckBox checkBox1 = new CheckBox("Show coordinates");
//        checkBox1.setValue(true);
//
//        checkBox1.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                CheckBox checkBox = (CheckBox) event.getSource();
//                checkb[0] = checkBox.getValue();
//                if (checkb[0]) {
////                Window.alert("si");
//                    Elements.body().add(el2).add(el);
//                } else {
//                    el2.remove();
//                    el.remove();
//                }
//            }
//        });
//
//        VerticalPanel panel = new VerticalPanel();
//        panel.setSpacing(10);
//        panel.add(checkBox1);
//        RootPanel.get("gwtContainer").add(panel);
//
//
//        HTMLElement el3 = Elements.span().style("font-weight: bold;").get();
//        HTMLElement el4 = Elements.span().add("touch position: ").get();
//        Elements.body().add("    ---     ").add(el3).add(el4);
//        RxElemento.fromEvent(document, touchstart)
//                .subscribe(ev -> el3.textContent = Math.round(ev.changedTouches.item(0).pageX)
//                        + ", " + Math.round(ev.changedTouches.item(0).pageY));
//
//
////        Observable<List<double[]>> mousePos$ = mouseMove(panel)
////                .map(e ->
//////                        e.ge
////                        getMouse22(e))
//////                        getMouse(e,body))
////                .buffer(3, 1);
//
//
////        Observable<double[]> mousePos2$ = mouseMove(panel)
////                .subscribe(e ->
////                                new int[]{e.getClientY(),e.getClientY()}
////                        );
//
//
////        Observable mousePos2$ = Observable.switchOnNext(mouseMove(panel),0);
//
//
////        HTMLElement el5 = Elements.span().style("font-weight: bold;").get();
////        HTMLElement el6 = Elements.span().add("touch position: ").get();
////        Elements.body().add("    ---     ").add(el6).add(el6);
////        RxElemento.fromEvent(document, mousePos$)
////                .subscribe(
////                        ev -> el5.textContent = ev.flatMap(
////                                o ->
////                                        new double[]{o.get(0),o.get(1)}
////                        ).last());
//
//
////        Observable<List<double[]>> mouseDiff$ = mouseMove(canvas)
////                .map(e -> canvasPosition(canvas, e))
////                .buffer(3, 1);
////
////        Observable<List<double[]>> mouseDrag$ = mouseDown(canvas).compose(log("mouse down"))
////                .flatMap(e -> mouseDiff$
////                        .doOnSubscribe(s -> DOM.setCapture(canvas.getElement()))
////                        .doOnDispose(() -> DOM.releaseCapture(canvas.getElement()))
////                        .takeUntil(mouseUp(canvas).compose(log("mouse up"))));
////
////        Observable<List<double[]>> touchDiff$ = touchMove(canvas)
////                .map(e -> e.getTouches().get(0))
////                .map(e -> canvasPosition(canvas, e))
////                .buffer(3, 1);
////
////        Observable<List<double[]>> touchDrag$ = touchStart(canvas).compose(log("touch start"))
////                .flatMap(e -> touchDiff$
////                        .doOnSubscribe(s -> DOM.setCapture(canvas.getElement()))
////                        .doOnDispose(() -> DOM.releaseCapture(canvas.getElement()))
////                        .takeUntil(touchEnd(canvas).compose(log("touch end"))));
//
//
//        String[] manu22 = {" c "};
//
//
//        Disposable d = Observable.just("Hello world!")
//                .delay(1, TimeUnit.MICROSECONDS)
//                .subscribeWith(new DisposableObserver<String>() {
//                    @Override
//                    public void onStart() {
//                        System.out.println("Start!");
//                        manu22[0] += " a ";
//                    }
//
//                    @Override
//                    public void onNext(String t) {
//                        System.out.println(t);
//                        manu22[0] += t;
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        t.printStackTrace();
//                        manu22[0] += t;
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("Done!");
//                        manu22[0] += " b ";
//                    }
//                });
//
////        Thread.sleep(500);
////        // the sequence can now be disposed via dispose()
////        d.dispose();
//
//
//        VerticalPanel panel2 = new VerticalPanel();
//        TextBox newSymbolTextBox = new TextBox();
//        newSymbolTextBox.setText(manu22[0]);
//        panel.add(newSymbolTextBox);
//        RootPanel.get("gwtContainer2").add(panel);
//
//
//    }
//
////    private <T> Observable <T>MyMin( Observable<T> source)
////    {
////        return source.Aggregate(
////                (min, current) => Comparer<T>
////            .Default
////            .Compare(min, current) > 0
////            ? current
////            : min);
////    }
//
//
////    public static <T>Observable MyMax<T>( Observable<T> source)
////    {
////        var comparer = Comparer<T>.Default;
////        Func<T, T, T> max =
////        (x, y) =>
////        {
////            if(comparer.Compare(x, y) < 0)
////            {
////                return y;
////            }
////            return x;
////        };
////        return source.Aggregate(max);
////    }

//
//    private double[] getMouse22(MouseMoveEvent t) {
//        return new double[]{t.getClientX(), t.getClientY()};
//    }

//
//
// ____________________________________________
// ____________________________________________
// ____________________________________________
//
//
//

}