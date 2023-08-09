/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.beans;

import com.mycompany.falcon.entity.DataShow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.optionconfig.tooltip.Tooltip;

/**
 *
 * @author hainguyen
 */
@ManagedBean
@ViewScoped
public class CharBean {

    private List<DataShow> dataShowList = null;

    private BarChartModel stackedBarModel;

    private CheckboxBean checkboxBean = new CheckboxBean();

    @PostConstruct
    public void init() {
        System.out.println("init");
        checkboxBean.init();
        
        uploadDataShow();
  
    }
    
    public void uploadDataShow() {
        stackedBarModel = new BarChartModel();
        dataShowList = checkboxBean.getDataShowByFIlter();
        System.out.println(dataShowList);
        if (!dataShowList.isEmpty()) {

            ChartData data = new ChartData();

            Set<String> set = new HashSet<>();

            for (int i = 0; i < dataShowList.size(); i++) {
                set.add(dataShowList.get(i).getDate());
            }

            List<String> labels = new ArrayList<>();

            for (String date : set) {
                labels.add(date);
                Random rand = new Random(); 


                for (int i = 0; i < dataShowList.size(); i++) {
                    List<Number> dataVal = new ArrayList<>();

                    BarChartDataSet barDataSet = new BarChartDataSet();
                    barDataSet.setBackgroundColor("rgb("+(rand.nextInt(250) + 1)+" , "+(rand.nextInt(250) + 1) +", "+(rand.nextInt(250) + 1)+")");
                    System.out.println(barDataSet.getBackgroundColor());
                    if (dataShowList.get(i).getDate() == null ? date == null : dataShowList.get(i).getDate().equals(date)) {
                        barDataSet.setLabel(dataShowList.get(i).getBreakFilter());
                        dataVal.add(dataShowList.get(i).getImpression());
                        barDataSet.setData(dataVal);
                        data.addChartDataSet(barDataSet);
                        System.out.println(dataVal);
                    }

                }
                
                
            }
            System.out.println(labels);

            data.setLabels(labels);
            stackedBarModel.setData(data);

            System.out.println(stackedBarModel.getData());

            //Options
            BarChartOptions options = new BarChartOptions();
            CartesianScales cScales = new CartesianScales();
            CartesianLinearAxes linearAxes = new CartesianLinearAxes();
            linearAxes.setStacked(true);
            cScales.addXAxesData(linearAxes);
            cScales.addYAxesData(linearAxes);
            options.setScales(cScales);

            Title title = new Title();
            title.setDisplay(true);
            title.setText("Bar Chart");
            options.setTitle(title);

            Tooltip tooltip = new Tooltip();
            tooltip.setMode("index");
            tooltip.setIntersect(false);
            options.setTooltip(tooltip);

            stackedBarModel.setOptions(options);
        }

    }

    public BarChartModel getStackedBarModel() {
        return stackedBarModel;
    }

    public void setStackedBarModel(BarChartModel stackedBarModel) {
        this.stackedBarModel = stackedBarModel;
    }

    public List<DataShow> getDataShowList() {
        return dataShowList;
    }

    public void setDataShowList(List<DataShow> dataShowList) {
        this.dataShowList = dataShowList;
    }

    public CheckboxBean getCheckboxBean() {
        return checkboxBean;
    }

    public void setCheckboxBean(CheckboxBean CheckboxBean) {
        this.checkboxBean = CheckboxBean;
    }

}
