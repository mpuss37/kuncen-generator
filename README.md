# Kuncen-Gen

Kuncen-Gen is a project that provides a simple password generator implemented in Java. This project is designed to
create strong, random passwords based on user-defined criteria, such as length and character types. It is an easy-to-use
tool for generating secure passwords to enhance your security practices.

## Prerequisites

Before running this project, ensure you have the following installed:

- Java JDK (required version)
- [Other dependencies if any]

## Installation

1. Clone this repository to your local machine:

    ```sh
    git clone https://github.com/username/kuncen-gen.git
    ```

2. Navigate to the project directory:

    ```sh
    cd kuncen-gen
    ```

## Running the Project

To run the project, follow these steps:

1. Ensure that the shell script `kuncen-gen.sh` has execute permissions. You can grant execute permissions with the
   following command:

    ```sh
    chmod +x kuncen-gen.sh
    ```

2. Execute the shell script `kuncen-gen.sh` using the command:

    ```sh
    ./kuncen-gen.sh
    ```

## Usage

- **Running the Program**: After executing the script, you can run the program with the appropriate arguments. Example
  usage:

    ```sh
    kuncen-gen [CUSTOM_OPTIONS]...[LENGTH]...[CASE]        
    Example: kuncen-gen -lcns '10' upper
      -l, --length [values]    specified length default 8.
      -c, --case [upper/lower]     adjust case upper or lower.
      -n, --numeric with numeric digits.
      -s, --symbols [custom_char]     with symbol can add custom char.
      -e, --easy easy to read or write, support (Length, case).

    ```

- **Optional**: If there are specific arguments or options supported, describe them here.

## Project Structure

- `src/` - Source code of the project
- `kuncen-gen.sh` - Shell script to run the project
- `kuncen-gen.jar` - Executable JAR file
- [Other relevant directories or files]

## Contributing

If you wish to contribute to this project, please follow these guidelines:

1. Fork this repository
2. Create a new feature branch (`git checkout -b new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin new-feature`)
5. Create a Pull Request

## License

This project is licensed under the [license name]. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or need further assistance, please contact on my account instagram : @herdiii_99
