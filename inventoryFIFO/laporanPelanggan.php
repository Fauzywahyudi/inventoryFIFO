<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laporan Barang</title>
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <center>
                    <h2>SISTEM INFORMASI INVENTORY <br>TOKO DAYA FAMILY</h2>
                </center>
            </div>
            <div class="col-2">

            </div>
            <div class="col-12">
                <hr>
            </div>
            <div class="col-12">
                <center>
                    <h3>LAPORAN DATA PELANGGAN <br><span style="font-size: 20px;">Tanggal : <?php echo date('d/m/Y') ?></span></h3>

                </center>
            </div>
            <div class="col-12">
                <center>
                    <table border="1" width="100%">
                        <tr align="center">
                            <th>NO</th>
                            <th>Kode Pelanggan</th>
                            <th>Nama Pelanggan</th>
                            <th>Alamat</th>
                            <th>No HP</th>
                        </tr>
                        <?php include 'koneksi.php';

                        function dateConvert($data)
                        {
                            $result = "";
                            $year = substr($data, 0, 4);
                            $mount = substr($data, 5, 2);
                            $day = substr($data, 8, 2);
                            $result = $day . "-" . $mount . "-" . $year;
                            return $result;
                        }

                        $sql = $kon->query("SELECT * FROM pelanggan ORDER BY kd_pel ASC");

                        $no = 1;
                        while ($data = $sql->fetch_array()) {
                        ?>
                            <tr>
                                <td align="center"><?php echo $no ?></td>
                                <td><?php echo $data['kd_pel'] ?></td>
                                <td><?php echo $data['nm_pel'] ?></td>
                                <td><?php echo $data['alamat'] ?></td>
                                <td><?php echo $data['no_hp'] ?></td>
                            </tr>
                        <?php
                            $no++;
                        }

                        ?>
                    </table>
                </center>
            </div>
            <div class="col-8"></div>
            <div class="col-4">
                <br>
                <span>Padang, <?php echo date('d/m/Y') ?></span> <br>
                <span>Mengetahui</span>
                <p></p>
                <p><br></p>
                <p><br></p>
                ( xxxxxxxxx )
            </div>

        </div>
    </div>


    <script>
        print()
    </script>
</body>

<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>

<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>

</html>