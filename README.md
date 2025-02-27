# SecureShift Encryption-Decryption Program

## Description

This project implements a simple encryption and decryption algorithm in Java. The encryption program takes an input message and splits it into three segments (`dolph`, `kang`, and `bird`) based on specific conditions. The decryption program reconstructs the original message using the same logic in reverse.

## Features

- Encrypts a message by segmenting characters into different groups
- Decrypts the message back to its original form
- Uses ASCII manipulation for encoding placeholders
- Takes user input for encryption order

## Technologies Used

- **Java**: Core programming language
- **Scanner**: For user input handling
- **String Manipulation**: For processing text

## How It Works

### Encryption Process

1. Takes a message as input from the user
2. Segments characters into three strings:
   - `dolph`
   - `kang`
   - `bird`
3. Replaces processed characters with a placeholder (`char 231`)
4. Rearranges the segments based on three user-provided integer values
5. Outputs the final encrypted message

### Decryption Process

1. Takes the encrypted message as input
2. Determines segment lengths based on total characters
3. Splits the message back into `dolph`, `kang`, and `bird`
4. Reconstructs the original message by placing characters in their original positions
5. Outputs the decrypted message

## Usage

### Encrypting a Message

1. Compile and run `Encrypt.java`
2. Enter the message to encrypt
3. Enter three integer values to determine segment order
4. Copy the generated cipher text

### Decrypting a Message

1. Compile and run `Decrypt.java`
2. Enter the encrypted cipher text
3. Enter the same three integer values used during encryption
4. Retrieve the original message

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/RavitejaUppulapu/SecureShift.git

   ```

2. Navigate to the project directory:

```bash
cd SecureShift
```

3. Compile the Java files:

```bash
javac Encrypt.java Decrypt.java
```

4. Run the encryption program:

```bash
java Encrypt
```

5. Run the decryption program:

```bash
java Decrypt
```

## Repository Structure

```bash
📂 SecureShift
 ├── Encrypt.java    # Encryption logic
 ├── Decrypt.java    # Decryption logic
 ├── README.md       # Project documentation
```
