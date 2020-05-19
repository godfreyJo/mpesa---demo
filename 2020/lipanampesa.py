import requests
import keys
import base64
from datetime import datetime

unformatted_time = datetime.now()
formatted_time = unformatted_time.strftime("%Y%m%d%H%M%S")


data_to_encode = keys.business_shortCode + keys.lipa_na_mpesa_passkey + formatted_time

encoded_string = base64.b64encode(data_to_encode.encode())

decoded_password = encoded_string.decode("utf-8")


def lipa_na_mpesa():
    access_token = "Access-Token"
    api_url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest"
    headers = { "Authorization": "Bearer %s" % access_token }
    request = {

    "BusinessShortCode": keys.business_shortCode,
    "Password": decoded_password,
    "Timestamp": formatted_time,
    "TransactionType": "CustomerPayBillOnline",
    "Amount": " 1 ",
    "PartyA": keys.phone_number,
    "PartyB": keys.business_shortCode,
    "PhoneNumber": keys.phone_number,
    "CallBackURL": "https://aketchoyugi/callback",
    "AccountReference": " 123456789",
    "TransactionDesc": " Pay school Fees"
    }

    response = requests.post(api_url, json = request, headers=headers)

    print (response.text)