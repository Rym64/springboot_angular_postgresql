function currencyrate()
{
    let url = 'https://openexchangerates.org/api/',
        apiKey = '7fa3556ea5804da58697a66074759fac',
        currency = 'currencies.json',
        latest = 'latest.json';
    
    
    window.onload = function() {
        let fromName = document.getElementById('devise');
        let fromValue = document.getElementById('montant');
        let toName = document.getElementById('cur-to-name');
        let toValue = document.getElementById('montant_dt');
        let displayAmount = document.getElementById('taux_dechange');
        let displayCurrencyFrom = document.getElementById('display-from-currency');
        let displayCurrencyTo = document.getElementById('display-to-currency');
    
        fetch(url + currency + '?app_id=' + apiKey)
            .then(data => data.json())
            .then(obj => {
                let arr = [];
                for (let key in obj) {
                    arr.push(`<option value=${key} ${(key === 'TND') ? 'selected' : ''}>[${key}] ${obj[key]}</option>`);
                }
                let html = arr.join('');
                fromName.innerHTML = html;
                toName.innerHTML = html;
            })
            .catch(err => console.log(err));
    
        fromValue.addEventListener('click', () => {
            displayAmount.innerHTML = '...';
            displayCurrencyFrom.innerHTML = fromName.value;
            displayCurrencyTo.innerHTML = 'loading';
    
            fetch(url + latest + '?app_id=' + apiKey)
                .then(data => data.json())
                .then(obj => {
                    let x = obj.rates[fromName.value],
                        y = obj.rates[toName.value];
                    toValue.value = (fromValue.value * y) / x;
    
                    displayCurrencyTo.innerHTML = toName.value;
                    displayAmount.innerHTML = y / x;
                })
                .catch(err => {
                    alert('Api Call Was Faliure.');
                    console.log('error: ' + err);
                    displayAmount.innerHTML = '??';
                    displayCurrencyTo.innerHTML = 'Currency';
                });
        });
        fromName.addEventListener('click', () => {
            displayAmount.innerHTML = '...';
            displayCurrencyFrom.innerHTML = fromName.value;
            displayCurrencyTo.innerHTML = 'loading';
    
            fetch(url + latest + '?app_id=' + apiKey)
                .then(data => data.json())
                .then(obj => {
                    let x = obj.rates[fromName.value],
                        y = obj.rates[toName.value];
                    toValue.value = (fromValue.value * y) / x;
    
                    displayCurrencyTo.innerHTML = toName.value;
                    displayAmount.innerHTML = y / x;
                })
                .catch(err => {
                    alert('Api Call Was Faliure.');
                    console.log('error: ' + err);
                    displayAmount.innerHTML = '??';
                    displayCurrencyTo.innerHTML = 'Currency';
                });
        });
        
    }
}