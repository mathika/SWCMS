from fastapi import FastAPI, UploadFile, File
from PIL import Image
import tensorflow as tf
import numpy as np
import io

app = FastAPI()

# Load trained model
model = tf.keras.models.load_model("complaint_classifier.keras")

# Class names
classes = [
    "Garbage",
    "Road Damage",
    "Street Light",
    "Water Leakage",
    "Drainage"
]

@app.post("/predict")
async def predict(file: UploadFile = File(...)):
    image_bytes = await file.read()

    image = Image.open(io.BytesIO(image_bytes))
    image = image.resize((224,224))

    img = np.array(image)/255.0
    img = np.expand_dims(img, axis=0)

    prediction = model.predict(img)

    index = np.argmax(prediction)

    return {
        "category": classes[index],
        "confidence": float(np.max(prediction))
    }