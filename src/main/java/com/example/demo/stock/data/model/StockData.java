package com.example.demo.stock.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the stock_data database table.
 * 
 */
@Entity
@Table(name="stock_data")
@NamedQuery(name="StockData.findAll", query="SELECT s FROM StockData s")
public class StockData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stock_data_id")
	private Long stockDataId;

	private BigDecimal close;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="days_to_next_dividend")
	private Integer daysToNextDividend;

	private BigDecimal high;

	private BigDecimal low;

	@Column(name="next_weeks_close")
	private BigDecimal nextWeeksClose;

	@Column(name="next_weeks_open")
	private BigDecimal nextWeeksOpen;

	private BigDecimal open;

	@Column(name="percent_change_next_weeks_price")
	private Double percentChangeNextWeeksPrice;

	@Column(name="percent_change_price")
	private Double percentChangePrice;

	@Column(name="percent_change_volume_over_last_wk")
	private Double percentChangeVolumeOverLastWk;

	@Column(name="percent_return_next_dividend")
	private Double percentReturnNextDividend;

	@Column(name="previous_weeks_volume")
	private Long previousWeeksVolume;

	private Integer quarter;

	@Column(name="stock_name")
	private String stockName;

	private Long volume;

	public StockData() {
	}

	public Long getStockDataId() {
		return this.stockDataId;
	}

	public void setStockDataId(Long stockDataId) {
		this.stockDataId = stockDataId;
	}

	public BigDecimal getClose() {
		return this.close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDaysToNextDividend() {
		return this.daysToNextDividend;
	}

	public void setDaysToNextDividend(Integer daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public BigDecimal getHigh() {
		return this.high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return this.low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getNextWeeksClose() {
		return this.nextWeeksClose;
	}

	public void setNextWeeksClose(BigDecimal nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public BigDecimal getNextWeeksOpen() {
		return this.nextWeeksOpen;
	}

	public void setNextWeeksOpen(BigDecimal nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public BigDecimal getOpen() {
		return this.open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public Double getPercentChangeNextWeeksPrice() {
		return this.percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(Double percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public Double getPercentChangePrice() {
		return this.percentChangePrice;
	}

	public void setPercentChangePrice(Double percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public Double getPercentChangeVolumeOverLastWk() {
		return this.percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(Double percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public Double getPercentReturnNextDividend() {
		return this.percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(Double percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	public Long getPreviousWeeksVolume() {
		return this.previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(Long previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public Integer getQuarter() {
		return this.quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

}