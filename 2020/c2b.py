import requests
import keys
from requests.auth import HTTPBasicAuth



consumer_key = keys.consumer_key
consumer_secret = keys.consumer_secret
api_url = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials"

r = requests.get(api_url, auth=HTTPBasicAuth(consumer_key,consumer_secret))



json_response = r.json()

my_access_token = json_response['access_token']

def register_url():
    # access_token = "Access-Token"
    api_url = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl"

    headers = {"Authorization": "Bearer %s" % my_access_token}
    request = { "ShortCode": keys.short_code,
        "ResponseType": "Completed",
        "ConfirmationURL": "https://aketchoyugi.com/confirmation",
        "ValidationURL": "https://aketchoyugi.com/validation_url"}

    response = requests.post(api_url, json = request, headers=headers)

    print (response.text)

# register_url()

def  simulate_c2b_transaction():

    api_url = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate"

    headers = {"Authorization": "Bearer %s" % my_access_token}

    request = { 
        "ShortCode": keys.short_code,
        "CommandID": "CustomerPayBillOnline",
        "Amount":"2",
        "Msisdn": keys.test_msisdn,
        "BillRefNumber":"12345678"
        }

    response = requests.post(api_url, json = request, headers=headers)

    print (response.text)

simulate_c2b_transaction()