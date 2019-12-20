package com.omada.pithia.ui.controller;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.view.DhmiourgiaFoititwnView;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class DhmiourgiaFoititwnController {

    private final ViewController viewController;

    private final XrhstesService service;

    private DhmiourgiaFoititwnView view;

    private volatile Future<?> executingWork;

    public DhmiourgiaFoititwnController(ViewController viewController, XrhstesService service) {
        this.viewController = viewController;
        this.service = service;
    }

    public void setView(DhmiourgiaFoititwnView view) {
        this.view = view;
    }

    public void requestForParagwgh(int arithmosFoititwn) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        SwingWorker<Void,Void> work = new SwingWorker<Void, Void>() {

            private int created = 0;

            @Override
            protected Void doInBackground() throws Exception {

                File file = new File("Foititits_" + LocalDateTime.now());
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    view.showMessage("Exception : " + e.getMessage());
                    return null;
                }

                try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file), true)) {

                    while (created < arithmosFoititwn && !Thread.currentThread().isInterrupted()) {
                        Thread.sleep(200);//for testing reasons

                        String onomaFoititi = "onoma"+created;
                        String epwnumoFoititi = "epwnumo" + created;
                        LocalDate hmeromhniaGennhshs = LocalDate.now().minusYears(18);
                        StringBuilder onomaXrhsth = new StringBuilder();

                        for (int i = 0; i < 8; i++) {
                            onomaXrhsth.append(ThreadLocalRandom.current().nextInt(10));
                        }

                        if (service.find(onomaXrhsth.toString()) == null) {
                            StringBuilder kwdikos = new StringBuilder();
                            for (int i = 0; i < 7; i++) {
                                kwdikos.append(ThreadLocalRandom.current().nextInt(10));
                            }

                            view.showMessage("Δημιουργισα "+created+"/"+arithmosFoititwn+" φοιτητες.");

                            created++;

                            Foititis foititis = new Foititis(onomaFoititi, epwnumoFoititi, hmeromhniaGennhshs,
                                    onomaXrhsth.toString(), kwdikos.toString(), onomaXrhsth.toString() + "@edu.gr");

                            service.add(foititis);

                            printWriter.println("\n" + foititis);
                        }

                    }
                    view.showMessage("Δημιουργια Ολοκληρωθηκε.Ονομα αρχειου με κωδικους φοιτητων = "+file.getAbsolutePath());
                }catch (InterruptedException e){
                    if (created > 0) {
                        view.showMessage("Δημιουργια Ολοκληρωθηκε.Ονομα αρχειου με κωδικους φοιτητων = "+file.getAbsolutePath());
                    }
                    Thread.currentThread().interrupt();
                }catch (FileNotFoundException e) {
                    viewController.requestForShowErrorMessage("Exception : \n" + e.getMessage());
                } finally {
                    view.doneCreation();
                }

                return null;
            }

        };

        executingWork = executor.submit(work);
    }

    public void requestForStop() {
        if (executingWork != null) {
            executingWork.cancel(true);
        }
    }
}
