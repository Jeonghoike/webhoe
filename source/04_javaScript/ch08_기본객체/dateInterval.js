/* dateInterval.js */
Date.prototype.getIntervalDay =function(that){
    // now.getIntervalDay(openday) : now는 this가, openday는 that
    // if(this>that){
    //     var intervalMilliSec = this.getTime() - that.getTime();
    // }else{
    //     var intervalMilliSec = that.getTime() - this.getTime();
    // }
    let intervalMilliSec = Math.abs(this.getTime() - that.getTime());
    let day = Math.trunc(intervalMilliSec /(1000*60*60*24) );
    return day;
};

// let now = new Date();
// let openday = new Date(2023, 5, 26, 9, 30, 0); // 개강시점(23.6.26)
// console.log('now ~ openday 날짜 : ' + now.getIntervalDay(openday) + '일<br>');
// console.log('now ~ openday 날짜 : ' + openday.getIntervalDay(now) + '일<br>');